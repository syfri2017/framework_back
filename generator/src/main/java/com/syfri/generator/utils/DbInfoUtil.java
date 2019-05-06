package com.syfri.generator.utils;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import com.syfri.generator.model.Column;
import com.syfri.generator.model.GeneratorBean;

/**
 * 
 * <p>
 * Description: 获取数据库基本信息的工具类
 * </p>
 * 
 * @author xiaoyang.li
 * @date 2017年8月17日 下午1:00:34
 */
public class DbInfoUtil {
    private static Statement stmt = null;
    private static Connection conn;
    private static StringBuffer SSColumnSql=new StringBuffer("SELECT  a.name mc , ").
            append("b.name sjbzdlx , ").
            append("COLUMNPROPERTY(a.id, a.name, 'PRECISION') AS sjbzdcd , ").
            append("ISNULL(COLUMNPROPERTY(a.id, a.name, 'Scale'), 0) AS sjbzdxscd ,  ").    
            append("CAST(ISNULL(g.[value], '') as nvarchar(100)) AS bz ").
            append("FROM    syscolumns a ").
            append("LEFT JOIN systypes b ON a.xtype = b.xusertype ").
            append("INNER JOIN sysobjects d ON a.id = d.id ").
            append("AND d.xtype = 'U' ").
            append("AND d.name <> 'dtproperties' ").
            append("LEFT JOIN syscomments e ON a.cdefault = e.id ").
            append("LEFT JOIN sys.extended_properties g ON a.id = g.major_id ").
            append("AND a.colid = g.minor_id ").
            append("WHERE   d.name = '%s' ").
            append("ORDER BY a.id ,a.colorder") ;
    
    private static StringBuffer SSTableSql=new StringBuffer("select c.name,cast(isnull(f.[value], '') as nvarchar(100)) as remark from").
            append(" sys.objects c left join sys.extended_properties f on f.major_id=c.object_id and ").
            append(" f.minor_id=0 and f.class=1 where c.type='u'");
    //字段分类
    private static String[] NUMBER_TYPE={"DECIMA","NUMERIC","NUMBER"};
    private static String[] CHAR_TYPE={"NCHAR","NVARCHAR","CHAR","VARCHAR","NVARCHAR2","VARCHAR2"};
    private static String[] DATE_TYPE={"DATE","DATETIME"};
    private static String[] BN_TYPE={"TINYBLOB","MEDIUMBLOB","BLOB","LONGBLOB",
            "CLOB","NCLOB","BFILE","BINARY","VARBINARY"};
    public static final String ORACLE = "ORACLE";
    public static final String MYSQL= "MYSQL";
    public static final String SQLSERVER = "SQLSERVER";
    /**
     * 将带_的列名转换成驼峰式
     */
    private static String handleColumn(String columnName,String template){
        String[] arr = columnName.split("_");
        StringBuffer buffer = new StringBuffer(arr[0]);
        if("default".equals(template.trim())){
            for(int i=1;i<arr.length;i++){
                buffer.append(arr[i].substring(0, 1).toUpperCase()+arr[i].substring(1).toLowerCase());
            }
        }
        return buffer.toString();
    }

    /**
     * 数据库字段转java字段
     * @return
     */
    private static String db2beanType(String dataType){
        //
        String result ="String";
        if(isNumber(dataType)){
            result ="Integer";
        }
        if(isBn(dataType)){
            result ="byte[]";
        }
        if(isDate(dataType)){
            result ="date";
        }
        return result;
    }
    private static boolean isNumber(String zdlx){
        zdlx=zdlx.trim().toUpperCase();
        for(String type:NUMBER_TYPE){
            if(zdlx.equals(type)){
                return true;
            }
        }
        return false;
    }
    private static boolean isChar(String zdlx){
        zdlx=zdlx.trim().toUpperCase();
        for(String type:CHAR_TYPE){
            if(zdlx.equals(type)){
                return true;
            }
        }
        return false;
    }
    private static boolean isDate(String zdlx){
        zdlx=zdlx.trim().toUpperCase();
        for(String type:DATE_TYPE){
            if(zdlx.equals(type)){
                return true;
            }
        }
        return false;
    }
    private static boolean isBn(String zdlx){
        zdlx=zdlx.trim().toUpperCase();
        for(String type:BN_TYPE){
            if(zdlx.equals(type)){
                return true;
            }
        }
        return false;
    }

    public static List<String> listDBTableInfo(GeneratorBean gb) throws Exception{
        String driver= gb.getDriver();
        String url=gb.getUrl();
        String user=gb.getUser();
        String pwd=gb.getPwd();
        String sjklx=gb.getDbtype();

        if (null==conn||conn.isClosed()) {
            conn=getConnections(driver, url, user, pwd);
        }
        List<String> result=new ArrayList<>();
        if(sjklx.equals(ORACLE)){
            result=getOracleTable();
        }else if(sjklx.equals(MYSQL)){
            result=getMSAllTable();
        }else if(sjklx.equals(SQLSERVER)){
            result=getSSAllTable();
        }
        try {
            if (!conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if (!conn.isClosed()) {
                conn.close();
            }
        }

        return result;
    }
    
    public static List<Column> listDBColumnsInfo(GeneratorBean gb) throws Exception{
        String driver= gb.getDriver();
        String url=gb.getUrl();
        String user=gb.getUser();
        String pwd=gb.getPwd();
        String sjklx=gb.getDbtype();

        if (null==conn||conn.isClosed()) {
            conn=getConnections(driver, url, user, pwd);
        }
        List<Column> result=new ArrayList<>();
        if(sjklx.equals(ORACLE)||
                sjklx.equals(MYSQL)){
            result= getColumnsInfo(gb.getTableName());
        }else if(sjklx.equals(SQLSERVER)){
            result= getSSAllColumns(gb.getTableName());
        }
        try {
            if(!conn.isClosed()){
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if (!conn.isClosed()) {
                conn.close();
            }
        }
        return result;
    }

    
    /**
     * 获取sql server数据库信息
     * @return List<BzjcShujuyuan>
     * @throws Exception
     */
    private static List<String> getSSAllTable() throws Exception {
        
        List<String> result = new ArrayList<String>();
        Statement stmtTable = conn.createStatement();
        ResultSet rsTable = stmtTable.executeQuery(SSTableSql.toString() );
        
        while (rsTable.next()) {
            //获取表信息
            String tableName = rsTable.getString("name");
            if(StringUtils.isBlank(tableName)){
                continue;
            }
            String tableComment = rsTable.getString("remark");
            if(null==tableComment){
                tableComment="";
            }
            StringBuffer sb=new StringBuffer(tableComment).append(":").append(tableName);
            result.add(sb.toString());
        }
        rsTable.close();
        stmtTable.close();

        return result;
    }

    /**
     * 根据表名获取字段名集合
     * @param tableName
     * @return
     * @throws Exception
     */
    private static List<Column> getSSAllColumns(String tableName) throws Exception {
        List<Column> result = new ArrayList<Column>();
        // 获取字段信息
        Statement stmtColumn = conn.createStatement();
        ResultSet rsColumn = stmtColumn.executeQuery(String.format(SSColumnSql.toString(), tableName));
        while (rsColumn.next()) {
            Column zd = new Column();
            zd.setColumnName(rsColumn.getString("mc").toLowerCase());
            if(StringUtils.isBlank(rsColumn.getString("mc"))){
                continue;
            }
            zd.setComment(rsColumn.getString("bz"));
            zd.setMaxLength(rsColumn.getString("sjbzdcd"));
            zd.setDataType(rsColumn.getString("sjbzdlx"));
            zd.setNumeric_precision(rsColumn.getString("sjbzdxscd"));
            zd.setTableName(tableName);
            zd.setBeanComment(zd.getComment());
            zd.setBeanName(handleColumn(zd.getColumnName(),"default"));
            zd.setBeanType(db2beanType(zd.getDataType()));
            result.add(zd);
        }
        rsColumn.close();
        stmtColumn.close();

        return result;
    }
    /*
     * 获取MySQL的数据库字段和表信存入List<BzjcShujuyuan>
     */
    private static List<String> getMSAllTable() throws Exception {
        List<String> result = new ArrayList<String>();
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SHOW TABLES");
        String showSql="SHOW CREATE TABLE ";
        while (rs.next()) {
            String tableName = rs.getString(1);
            if(StringUtils.isBlank(tableName)){
                continue;
            }
            // 获取备注
            Statement stmtColumn = conn.createStatement();
            ResultSet rsColumn = stmtColumn.executeQuery(showSql+tableName );
            String comment="";
            if (rsColumn != null && rsColumn.next()) {
                String create = rsColumn.getString(2);
                comment = parse(create);
                if(null==comment){
                    comment="";
                }
            }
            StringBuffer sb=new StringBuffer(comment).append(":").append(tableName);
            rsColumn.close();
            stmtColumn.close();
            result.add(sb.toString());
        }

        rs.close();
        stmt.close();
        return result;
    }
    /*
     * 获取oracle的数据库字段和表信存入List<BzjcShujuyuan>
     */
    private static List<String> getOracleTable() throws Exception {
        List<String> result = new ArrayList<String>();
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select t.table_name from  tabs t ");
        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            if(StringUtils.isBlank(tableName)){
                continue;
            }

            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet resultSet = dbmd.getTables(null, "%", tableName, new String[] { "TABLE" });
            String REMARKS ="";
            if (resultSet != null && resultSet.next()) {
                 REMARKS = resultSet.getString("REMARKS");
                 if(null==REMARKS){
                     REMARKS="";
                 }
            }
            StringBuffer sb=new StringBuffer(REMARKS).append(":").append(tableName);
            resultSet.close();

            result.add(sb.toString());
        }
        rs.close();
        stmt.close();
        return result;
    }

    /**
     * 转换mysql的备注
     * @param all
     * @return
     */
    public static String parse(String all) {
        String comment = null;
        int index = all.indexOf("COMMENT='");
        if (index < 0) {
            return "";
        }
        comment = all.substring(index + 9);
        comment = comment.substring(0, comment.length() - 1);
        try {
            comment = new String(comment.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return comment;
    }
    /**
     * 根据数据库的连接参数，获取指定表的连接
     *
     * @param driver
     *            数据库连接驱动
     * @param url
     *            数据库连接url
     * @param user
     *            数据库登陆用户名
     * @param pwd
     *            数据库登陆密码
     * @return Connection 连接
     */
    public static Connection getConnections(String driver, String url, String user, String pwd) throws Exception {
        Connection conn = null;
        Properties props = new Properties();
        props.put("remarksReporting", "true");
        props.put("user", user);
        props.put("password", pwd);
        Class.forName(driver);
        conn = DriverManager.getConnection(url, props);
        return conn;
    }

    // 其他数据库不需要这个方法 oracle和db2需要
    private static String getSchema(Connection conn) throws Exception {
        String schema;
        schema = conn.getMetaData().getUserName();
        if ((schema == null) || (schema.length() == 0)) {
            throw new Exception("ORACLE数据库模式不允许为空");
        }
        return schema.toUpperCase().toString();
    }
    /**
     * 解析表字段
     *mysql和oracle
     * @return
     */
    public static List<Column> getColumnsInfo(String tableName) {
        List<Column> result = new ArrayList<Column>();

        try {
            ResultSet rs = conn.getMetaData().getColumns(null, getSchema(conn), tableName.toUpperCase(), "%");
            while (rs.next()) {
                Column zd = new Column();
                String colName = rs.getString("COLUMN_NAME").toLowerCase();
                if(StringUtils.isBlank(colName)){
                    continue;
                }
                String remarks = rs.getString("REMARKS");
                String dbType = rs.getString("TYPE_NAME");
                /*
                 * 列表示给定列的指定列大小。对于数值数据，这是最大精度。 对于字符数据，这是字符长度。对于日期时间数据类型， 这是
                 * String 表示形式的字符长度（假定允许的最大小数秒组件的精度）。 对于二进制数据，这是字节长度。对于 ROWID
                 * 数据类型，这是字节长度。 对于列大小不适用的数据类型，则返回 Null。
                 */
                String length = rs.getString("COLUMN_SIZE");
                String digits = rs.getString("DECIMAL_DIGITS");
                zd.setColumnName(colName);
                zd.setComment(remarks);
                zd.setMaxLength(length);
                zd.setDataType(dbType);
                zd.setNumeric_precision(digits);
                zd.setTableName(tableName);
                zd.setBeanComment(zd.getComment());
                zd.setBeanName(handleColumn(zd.getColumnName(),"default"));
                zd.setBeanType(db2beanType(zd.getDataType()));
                result.add(zd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

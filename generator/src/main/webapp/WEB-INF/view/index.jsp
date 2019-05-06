<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
String ctx = url + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>代码生成器</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="stylesheet" href="../static/css/normalize.css">
    <link rel="stylesheet" href="../static/css/bootstrap.css">
    <link rel="stylesheet" href="../static/css/mmGrid.css">
    <link rel="stylesheet" href="../static/css/mmGrid-bootstrap.css">
    <link rel="stylesheet" href="../static/css/mmPaginator.css">
    <link rel="stylesheet" href="../static/css/mmPaginator-bootstrap.css">
    <link rel="stylesheet" href="../static/css/jquery.mloading.css">
    <style>
        html,
        body{
            font-family: 'Helvetica Neue',helvetica, "Hiragino Sans GB",'Microsoft YaHei', "WenQuanYi Micro Hei", sans-serif;
            font-size: 18px;
            color: #444;
        }
        .btn{
            font-size: 14px;
        }
        .btnPrice {
            display: block;
            width: 16px;
            height: 16px;
            margin: 0px auto;
            background: url(../static/image/botton_g1.gif) no-repeat;
        }
        .btnPrice:hover {
            background: url(../static/image/botton_g2.gif) no-repeat;
        }
        .lable{
        	margin-left: 50px;
        }
		.input{
			width: 274px;
		}
		.inputs{
			width: 288px;
		}

    </style>
    <!--[if lt IE 9]>
    <script src="js/vendor/html5shiv.js"></script>
    <![endif]-->
    <script src="../static/js/modernizr-2.6.2.min.js"></script>
</head>
<body style="padding: 40px;">
	<form id="form">
	    <div>
	        <div style="margin-bottom: 5px;text-align: center">
	         	<h2>Generator生成器</h2><br>
				<div style="font-weight: bold;float:left;margin-left: 200px;margin-top: 30px;">数据库配置</div>
				<span style="margin-left: -160px">库&nbsp;&nbsp;类&nbsp;&nbsp;型：</span>
				<select  id="dbtype" name="dbtype" class="inputs" >
					<option value="ORACLE" selected>ORACLE</option>
					<%--<option value="MYSQL">MYSQL</option>--%>
					<%--<option value="SQLSERVER">SQLSERVER</option>--%>
				</select>
				<span class="lable">驱&nbsp;&nbsp;动&nbsp;&nbsp;名：</span>
				<input class="input" type="text" id="driver" name="driver" placeholder="驱动名" value="oracle.jdbc.OracleDriver">
				<span class="lable">地址名称：</span>
				<input class="input" type="text" id="url" name="url"  placeholder="url名称" value="jdbc:oracle:thin:@10.119.119.205:1521/XFXHDB" ><br>

				<span class="lable" style="margin-left: -160px">用&nbsp;&nbsp;户&nbsp;&nbsp;名：</span>
				<input class="input" type="text" id="user" name="user" placeholder="用户名" value="XFXHZH">
				<span class="lable">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
				<input class="input" type="password" id="pwd" name="pwd" value="XFXHZH">
				<input class="btn btn-success" style="margin-left: 350px;" title="获取数据库配置的数据源数据" type="button"id="doGetTables" class="btn btn-info" value="获取数据"/>
				<br>
				<br><br>
				<div style="font-weight: bold;float:left;margin-left: 200px;margin-top: 30px;">生成器配置</div>
				<span class="lable" style="margin-left: -160px">项目名称：</span>
				<input class="input" type="text" id="projectName" name="projectName" placeholder="项目名称:framework" >
				<span class="lable">模块名称：</span>
				<input class="input"type="text" id="modelName" name="modelName" placeholder="模块名称:userservice" >
				<span class="lable">包&nbsp;&nbsp;路&nbsp;&nbsp;径：</span>
				<input class="inputs" type="text" id="basePath" name="basePath" placeholder="包路径:com.syfri" style="width:274px" value="com.syfri"><br>

				<span style="margin-left: -165px">对&nbsp;&nbsp;应&nbsp;&nbsp;表：</span>
				<select class="inputs" id="tableName" name="tableName" onchange="doGetColumn(this.value)"></select>
				<span class="lable" style="margin-left: 50px;">表&nbsp;&nbsp;别&nbsp;&nbsp;名：</span>
				<input class="input" type="text" id="prefix" name="prefix" placeholder="表别名:t">

				<button id="generate" class="btn btn-info" title="生成生成器配置的代码模板"  style="margin-left: 355px;">&nbsp;&nbsp;生&nbsp;&nbsp;成&nbsp;&nbsp;</button>
			</div>
	        <table id="mmg" class="mmg">
	            <tr>
	                <th rowspan="" colspan=""></th>
	            </tr>
	        </table>
	        <div id="pg" style="text-align: right;"></div>
	    </div>
	</form>

    <script src="../static/js/jquery-1.9.1.min.js"></script>
    <script src="../static/js/plugins.js"></script>
    <script src="../static/js/json2.js"></script>
    <script src="../static/js/mmGrid.js"></script>
    <script src="../static/js/mmPaginator.js"></script>
    <script src="../static/js/jquery.mloading.js"></script>
<script>
    $(document).ready(function(){
        doGetTables()
        $('#generate').on('click', function(){
       	    var options = {
       	    	url:'/doGenerate?now='+new Date().valueOf(),
                type: 'post',
                data: $("#form").serialize(),
                beforeSend:function(XHR){
                	$("body").mLoading();
                },
                success: function (data) {
                    location.href="/doDownload?time="+data;
                	$("#loadingText").html("生成成功！")
                	setTimeout(function () {
                		$("#loading").remove();
                	}, 1000);
                }
            };
            $.ajax(options);
            return false;
        });
        $('#doGetTables').on('click', function(){
            $("#tableName").empty();
            doGetTables()
        })
     });

    function doGetTables() {
        debugger

        var t = new Date().valueOf();
        $.ajax({
            type : "POST", //用POST方式传输
            url : '/doGetTables?now='+t, //目标地址
            data: $("#form").serialize(),
            async:false,
            success : function(data) {
                if(data["error"]){
                    alert(data["error"])
				}
                var tableName = "";
                $("#projectName").val(data["projectName"]);
                $("#modelName").val(data["modelName"]);
               // $("#genPath").val(data["genPath"]);
                $("#prefix").val(data["prefix"]);
                var list = data["list"];
                for(var i =0;i<list.length;i++){
                    var arr = list[i].split(":");
                    if(i==0) tableName = arr[1];
                    $("#tableName").prepend("<option value="+arr[1]+">"+arr[0]+" ["+arr[1]+"] </option>");
                }
                if(""!=tableName){
                    doGetColumn(tableName);
                }
            }
        });
    }
    
        
	function doGetColumn(tableName){
	   var fixed = function(val1,val2){
              if(val1 == val2){
                  return 'selected=selected';
              }
              return "";
          };
        var cols = [
            {title:'序号',titleHtml: '<span style="cursor: help;color: #b00;">序号</span>', name:'', width: 35, align: 'center',lockWidth:true,  
             	renderer: function(val,item,rowIndex){return rowIndex+1;}
            },
{title:'数据库信息',align: 'center', cols:[
            { title:'列名', name:'columnName' ,width:80, sortable: true, align:'left',renderer: function(val,item,rowIndex){
            	 return "<input type='hidden'  name='columnList["+rowIndex+"].columnName' value="+val+">"+val;
	        }},
            { title:'字段描述', name:'comment' ,width:80, align:'left', sortable: true,renderer: function(val,item,rowIndex){
            	 return "<input type='hidden'  name='columnList["+rowIndex+"].comment' value="+val+">"+val;
	        }},
            { title:'字段长度', name:'maxLength' ,width:40, align:'left', sortable: true},
            { title:'字段类型', name:'dataType' ,width:80, sortable: true, align:'left',renderer: function(val,item,rowIndex){
            	 return "<input type='hidden'  name='columnList["+rowIndex+"].dataType' value="+val+">"+val;
	        }},
            { title:'字段精度', name:'numeric_scale' ,width:40, align:'center', sortable: true},
            { title:'是否为空', name:'isNullable' ,width:40, align:'center', sortable: true,renderer: function(val){
            	 if(val == 'YES'){
                     return '是';
                 }else{
                     return '否';
                 }
            }}]},
{title:'Bean信息',align: 'center', cols:[
            { title:'Bean名称', name:'beanName' ,width:100, align:'center', sortable: true,renderer: function(val,item,rowIndex){
                return "<input type='text' style='width:100px' name='columnList["+rowIndex+"].beanName' value="+val+">";
            }},
            { title:'Bean类型', name:'beanType' ,width:60, align:'center', sortable: true,renderer: function(val,item,rowIndex){
            	return '<select style="width:100px" name="columnList['+rowIndex+'].beanType">'+
            			'<option value="Integer" '+fixed(val,"Integer")+' >Integer</option>'+
            			'<option value="long" '+fixed(val,"long")+'>long</option>'+
            			'<option value="String" '+fixed(val,"String")+'>String</option>'+
            			'<option value="String" '+fixed(val,"date")+'>date</option>'+
            			'<option value="byte[]" '+fixed(val,"byte[]")+'>byte[]</option>'+
            			'<option value="float" '+fixed(val,"float")+'>float</option>'+
            			'<option value="double" '+fixed(val,"double")+'>double</option>'+
            			'</select>'
	        }},
            { title:'Bean描述', name:'beanComment' ,width:150, align:'center', sortable: true,renderer: function(val,item,rowIndex){
                return "<input type='text' style='width:150px' name='columnList["+rowIndex+"].beanComment' value="+val+">";
            }}]},
            { title:'操作', name:'' ,width:150, align:'center', lockWidth:true, lockDisplay: true, renderer: function(val,item,rowIndex){
                return '<button  style="width:80px" class="btn btn-danger">删除</button>'
            }}
        ];


        var mmg = $('.mmg').mmGrid({
            height: 700
            , cols: cols
            , url: '/doGetColumns?now='+new Date().valueOf()
            , method: 'post'
            , remoteSort:true
           // , items: items
           // , sortName: 'SECUCODE'
           // , sortStatus: 'asc'
           // , multiSelect: true
          //  , checkCol: true
            , fullWidthRows: true
            , autoLoad: false
           /*  , plugins: [
                $('#pg').mmPaginator({})
            ] */
            , params: function(){
              return {
            	  tableName: $('#tableName').val(),
				  dbtype:$('#dbtype').val(),
                  driver:$('#driver').val(),
                  url:$('#url').val(),
                  user:$('#user').val(),
                  pwd:$('#pwd').val()
              }

            }
        });


        mmg.on('cellSelected', function(e, item, rowIndex, colIndex){
            console.log('cellSelected!');
            console.log(this);
            console.log(e);
            console.log(item);
            console.log(rowIndex);
            console.log(colIndex);
            if($(e.target).is('.btn-danger') && confirm('你确定要删除该行记录吗?')){
                e.stopPropagation(); //阻止事件冒泡
                mmg.removeRow(rowIndex);
            }
        }).on('loadSuccess', function(e, data){
            //这个事件需要在数据加载之前注册才能触发
            console.log('loadSuccess!');
            console.log(data);
            console.log(mmg.rowsLength());
        }).on('rowInserted', function(e, item, index){
            console.log('rowInserted!');
            console.log(item);
            console.log(index);
            console.log(mmg.rowsLength());
        }).on('rowUpdated', function(e, oldItem, newItem, index){
            console.log('rowUpdated!');
            console.log(oldItem);
            console.log(newItem);
            console.log(index);
        }).on('rowRemoved', function(e, item, index){
            console.log('rowRemoved!');
            console.log(item);
            console.log(index);
            console.log(mmg.rowsLength());
        }).load();

	}
	
	function doGenerate(){
		
	}
</script>
</body>
</html>
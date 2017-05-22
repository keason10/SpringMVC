<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录成功</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/util/jquery/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/util/extjs/ext-all-debug.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/util/extjs/locale/ext-lang-zh_CN.js"></script>
    <link  href="${pageContext.request.contextPath}/util/extjs/resources/ext-theme-classic/ext-theme-classic-all-debug.css" rel="stylesheet"/>
    <script type="text/javascript">
        Ext.require([
            'Ext.grid.*',
            'Ext.data.*',
            'Ext.panel.*'
        ]);
        Ext.onReady(function(){

//            var searchBtn = Ext.create('Ext.Button', {
//                text     : '搜索',
//                renderTo : Ext.getBody(),
//                listeners: {
//                    click: function() {
//                        var data2 = Ext.getCmp('formSearchPanel').getValues();
//                       $.ajax({
//                           url:"/controller/student/data/list",
//                           method:"POST",
//                           dataType:"json",
//                           data:{},
//                           success:function (str) {
//                                store  = str;
//                           }
//                       })
//                    }
//                }
//            });

            var sexCom = Ext.create('Ext.data.Store', {
                fields: ['sex_id','sex_name'],
                data : [
                    {"sex_id":"1001","sex_name":"WOMAN"},
                    {"sex_id":"1002","sex_name":"MAN"}
                ]
            });
            var formPanel=Ext.create('Ext.form.Panel', {
                title: '查询学生信息',
                width: 1200,
                bodyPadding: 10,
                id:'formSearchPanel',
                items: [{
                    xtype: 'fieldcontainer',
                    fieldLabel: '查询条件',
                    labelWidth: 100,

                    // The body area will contain three text fields, arranged
                    // horizontally, separated by draggable splitters.
                    layout: 'hbox',
                    items: [{
                        xtype: 'textfield',
                        name:"id",
                        id:'formSearchPanel_id',
                        fieldLabel: '学生编码',
                    }, {
                        xtype: 'splitter'
                    },{
                        xtype: 'combobox',
                        ld:'formSearchPanel_sex',
                        name:'sex',
                        fieldLabel:'学生性别',
                        queryMode: 'local',
                        displayField: 'sex_name',
                        valueField: 'sex_name',
                        store:sexCom
                    },{
                        xtype: 'splitter',
                        width:30
                    },{
                        xtype:'button',
                        text: '清空条件',
                        listeners: {
                            click: function() {
                                var data2 = Ext.getCmp('formSearchPanel');
                                data2.getComponent('formSearchPanel_id').setValue({});
                            }
                        }
                    },{
                        xtype: 'splitter',
                        width:30
                    },{
                        xtype:'button',
                        text: '搜索',
                        listeners: {
                            click: function() {
                                var data2 = Ext.getCmp('formSearchPanel').getValues();
                                store.proxy.url='/controller/student/data/param/list';
                                store.proxy.extraParams=data2;
                                store.load();

                            }
                        }
                    }
                    ]
                }],
                renderTo: Ext.getBody()
            });


            Ext.define('Student', {
                extend: 'Ext.data.Model',
                fields: ['id', 'name', 'pwd','sex']
            });
            var store = Ext.create('Ext.data.JsonStore', {
                model: 'Student',
                proxy: {
                    type: 'ajax',
                    url: '/controller/student/data/list',
                    reader: {
                        type: 'json',
                        root: 'data'
                    },
                    actionMethods: {
                        read   : 'POST'
                    },
                    isSynchronous:true
                }
            });
            store.load();

            var listView = Ext.create('Ext.grid.Panel', {
                width:1200,
                height:250,
                collapsible:true,
                title:'学生信息列表<i>(选择了 0 行)</i>',
                renderTo: Ext.getBody(),
                store: store,
                multiSelect: true,
                viewConfig: {
                    emptyText: 'No images to display'
                },

                columns: [{
                    text: '学生编码',
                    flex: 300,
                    dataIndex: 'id'
                },{
                    text: '学生姓名',
                    flex: 300,
                    dataIndex: 'name'
                },{
                    text: '学生性别',
                    flex: 300,
                    dataIndex: 'sex'
                },{
                    text: '学生密码',
                    flex: 300,
                    dataIndex: 'pwd'
                }]
            });

            // little bit of feedback
            listView.on('selectionchange', function(view, nodes){
                var len = nodes.length,
                        suffix = len === 1 ? '' : 's',
                        str = '学生信息列表<i>(选择了 {0} 行)</i>';

                listView.setTitle(Ext.String.format(str, len, suffix));
            });
        });
    </script>
</head>
<body>
</body>
</html>

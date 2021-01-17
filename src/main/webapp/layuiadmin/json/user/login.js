layui.config({
    base: '../../layuiadmin/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'user'], function(){
    var $ = layui.$
        ,setter = layui.setter
        ,admin = layui.admin
        ,form = layui.form
        ,router = layui.router()
        ,search = router.search;
    form.render();
    //提交
    form.on('submit(LAY-user-login-submit)', function(obj){
        //请求登入接口
        admin.req({
            url: 'http://192.168.137.1:8879/user/login' //实际使用请改成服务端真实接口
            ,data: JSON.stringify(obj.field)
            ,type: "POST"
            ,datatype:'json'
            ,contentType:'application/json'
            ,success: function(res) {
                if (res.code == 200) {
                    //请求成功后，写入 access_token
                    layui.data(setter.tableName, {
                        key: setter.request.tokenName
                        , value: res.data.access_token
                    });

                    //登入成功的提示与跳转
                    layer.msg('登入成功', {
                        offset: '15px'
                        , icon: 1
                        , time: 1000
                    }, function () {
                        location.href = '../'; //后台主页
                    });
                }else {
                    layer.msg(result.msg, {icon: 5});
                                refreshCode();
                }
            }
        })
        return false;
    })

});

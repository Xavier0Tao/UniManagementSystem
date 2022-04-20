
var registerCard = new Vue({
    el:"#login-card",
    data:{
        msg:"message",
        show_stu_form:0,
        show_tea_form:0,
    },
    methods:{
        click_role_tea:function(){
            this.show_stu_form=0;
            this.show_tea_form=1;
        },
        click_role_stu:function(){
            this.show_tea_form=0;
            this.show_stu_form=1;
        },
        formCheck:function(obj){
            // window.location.href="http://121.5.43.28/";
            
        }
    }
})



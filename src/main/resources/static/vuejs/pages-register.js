
var registerCard = new Vue({
    el:"#register-card",
    data:{
        msg:"message",
        show_stu_form:0,
        show_tea_form:0,
        sex:"",
        sex_message:"",
        stu:{
            sname:"",
            id:"",
            collid:"",
            sori:"",
            sex:""
        },
        teacher:{
            name:"",
            id:"",
            trole:"",
            collegeId:""
        }
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
            if((obj.sex != 'male' && obj.sex!= 'female') && obj.sex !=''){
                alert("请输入正确性别...male 或 female");
                return false;
            }
                
            // if(this.show_stu_form === 1){
            //     var param = JSON.stringify(this.stu);
            //     axios.post("http://localhost:30/students/register",{param})
            //     .then(function(response){
            //         console.log(response);
            //     },function(error){
            //         alert("error"+error);
            //     })
            // }
        
        },
        submitForm:function(obj){
            
        }
    }
})



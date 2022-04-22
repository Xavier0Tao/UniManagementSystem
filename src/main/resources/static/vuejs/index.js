
var item = document.querySelector("#testItem");
item.innerText = 'test content...';
// item.innerHTML = "test innerHTML...";

var item = new Vue({
    el: "#testItem",
    data: {
        msg: "message"
    },
    methods: {
        test1:function(){
            alert("test...");
        }
    }
});


window.onload=function(){
    
    var params = new URLSearchParams();

    params.append("teacherId",8);
    axios.post("http://localhost:30/teachers/login",params)
    .then(function(response){
        console.log(response);
    });

    alert("send successfully...");
}

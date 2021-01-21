
const v1 = new Vue({
    el:"#main",
    data:{
        title:"Initializing Main Page...",
        result:"",
        edus:new Array(),
        works:new Array(),
        user:{
            id:0,
            name:"",
            age:"",
            city:"",
            address:"",
            email:"",
            phone:"",
            facebook:"",
            linkedin:"",
            twitter:"",
            sex:"",
            description:""
        },
        edu:{
            id:0,
            start:"",
            end:"",
            school:"",
            study:"",
            description:""
        },
        work:{
            id:0,
            start:"",
            end:"",
            company:"",
            job:"",
            description:""
        },
        skill:{
            id:0,
            keywords:""
        },
        specialty1:{
            id:0,
            name:"",
            description:""
        },
        specialty2:{
            id:0,
            name:"",
            description:""
        },
        count:0
    },
    methods:{
        male:function(){this.user.sex="male";},female:function(){this.user.sex = "female";},
        userClick:function(){
            //Provide User Information
            //id
            let index = layer.msg("Generating User Basic Information...",{icon:16});
            this.$http.post("v1/user/insert",v1.user,{"emulateJSON":true}).then(function(res){
                console.log(res.body);
                v1.user.id=res.body.data;
                layer.close(index);
                layer.msg("User Information Generated Success!");
            },function(res){
                alert(res.statusText);
                layer.close(index);
                layer.msg("Failed to Generate User Information");
            });
        },
        saveWork:function(){
            //save userid
            v1.work.userid = v1.user.id;
            // save work information to works
            v1.works.push(Object.assign({}, v1.work));
            v1.work.id=0;
            v1.work.start="";
            v1.work.end="";
            v1.work.company="";
            v1.work.job="";
            v1.work.description="";
        },

        backWork:function(){

            v1.works = new Array();
        },

        saveEdu:function(){
            //save userid
            v1.edu.userid = v1.user.id;
            //save education info to edus
            v1.edus.push(Object.assign({}, v1.edu));
            v1.edu.description="";
            v1.edu.end="";
            v1.edu.id=0;
            v1.edu.school="";
            v1.edu.start="";
            v1.edu.study="";
        },
        backEdu:function(){
            v1.edus = new Array();
        },

        workClick:function(){
            //save userid
            v1.work.userid = v1.user.id;
            // save work experience to works
            v1.works.push(Object.assign({}, v1.work));
        },
        eduClick:function(){
            //save userid
            v1.edu.userid = v1.user.id;
            //save education info to edus
            v1.edus.push(Object.assign({}, v1.edu));
        },
        skillClick:function(){
            //save userid
            v1.skill.userid=v1.user.id;
        },
        submitClick:function(){
            //save specialty1 and specialty2 of the userid
            v1.specialty1.userid=v1.user.id;
            v1.specialty2.userid=v1.user.id;
            //passing info respectively
            let x1 = 0;
            for(i=0;i<v1.edus.length;i++){
                v1.result = "Saving Education Background Information List...";
                this.$http.post("v1/edu/insert",v1.edus[i],{"emulateJSON":true}).then(function(res){
                    console.log(res.body);
                    console.log("i="+i);
                    console.log("v1.edus.length="+v1.edus.length);
                    if(x1==0){
                        x1++;
                        v1.result = "Saving Work Experience Information...";
                        //save work experience
                        for(i=0;i<v1.works.length;i++){
                            this.$http.post("v1/work/insert",v1.works[i],{"emulateJSON":true}).then(function(res){
                                console.log(res.body);
                                console.log("i="+i);
                                console.log("v1.works.length="+v1.works.length);
                                if(x1 == 1){
                                    x1++;


                                    //save speciality list
                                    v1.result = "Saving Speciality Information List...";
                                    this.$http.post("v1/skill/insert",v1.skill,{"emulateJSON":true}).then(function(res){
                                        console.log(res.body);
                                        v1.result = "Saving Speciality Information...";

                                        this.$http.post("v1/specialty/insert",v1.specialty1,{"emulateJSON":true}).then(function(res){
                                            console.log(res.body);
                                            v1.count++;
                                            if(v1.count == 2){
                                                v1.title = "initialize successfully：";
                                                v1.result = "visit address：<a href='u.html?userid="+v1.user.id+"'>click to visit</a>"
                                            }
                                        },function(res){
                                            alert(res.statusText);
                                            v1.result = "failed to initialize";
                                        });

                                        //speciality two

                                        this.$http.post("v1/specialty/insert",v1.specialty2,{"emulateJSON":true}).then(function(res){
                                            console.log(res.body);
                                            v1.count++;
                                            if(v1.count == 2){
                                                v1.title = "initialize successfully：";
                                                v1.result = "visit address：<a href='u.html?userid="+v1.user.id+"'>click to visit</a>"
                                            }

                                        },function(res){
                                            alert(res.statusText);
                                            layer.close(index);
                                            v1.result = "failed to save speciality two";
                                        });
                                    },function(res){
                                        alert(res.statusText);
                                        v1.result = "ailed to save speciality list";
                                    });
                                }
                            },function(res){
                                alert(res.statusText);
                                v1.result = "failed to save work experience";
                            });
                        }
                    }
                },function(res){
                    alert(res.statusText);
                    v1.result = "failed to save education information";
                });
            }

        }
    }
});
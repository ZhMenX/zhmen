<template>
  <div class="login-wrap">
    <el-form  class="login-container">
      <h1 class="title">用户注册</h1>
      <el-form-item >
        <el-input type="text" placeholder="用户账号" v-model="userName" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item >
        <el-input type="text" placeholder="昵称" v-model="nickname" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item >
        <el-input type="password" placeholder="密码" v-model="password" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item >
        <el-input type="password" placeholder="确认密码" v-model="password1" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="doRegister" style="width: 48%;">注册</el-button>
        <el-button type="primary" @click="doLogin" style="width: 48%; margin-left: 10px">返回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import qs from "qs";
import { mapMutations } from "vuex";

export  default{
  name:'Register',
  data:function(){
    return{
      userName:'',
      nickname:'',
      password:'',
      password1:'',
    }
  },
  methods:{
    doRegister:function(){
      let user = {
        id : this.$store.getters.getID,
        userName: this.userName,
        password: this.password,
        nickName: this.nickname,
        userType: 1,
      }
      console.log(qs.parse(user));
      // let userinfo = new URLSearchParams();
      // userinfo.append("username",this.username);
      // userinfo.append("password",this.password);
      // userinfo.append("nickname",this.nickname);
      // console.log(userinfo);
      this.$http.post("/register",qs.parse(user),{headers: {isToken: false}})
        .then(res => {
          const userInfo = res.data.data;
          this.$store.commit("SET_USERINFO", userInfo);
          this.$store.commit("SET_ID",userInfo.id);
          console.log(res.data.data)
          this.$router.push("/login");
          if (res.data.code === 200){
            this.$message({
              message: '恭喜你，注册成功',
              type: 'success'
            });
          }
          else {
            this.$message.error(res.data.data);
          }
        })
        .catch(err =>{
          console.log(err);
        })
    },
    doLogin:function(){
      this.$router.push('/')
    }

  }
}

</script>

<style scoped>
.login-wrap {
  box-sizing: border-box;
  width: 100%;
  height: 100%;
  padding-top: 10%;
  padding-bottom: 7%;
  background-image: url("../assets/image/background.jpg");
  background-color: #39a1ff;
  background-repeat: no-repeat;
  background-position: center right;
  background-size: 100%;
}

.login-container {
  border-radius: 10px;
  margin: 0px auto;
  width: 350px;
  padding: 30px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  text-align: left;
  box-shadow: 0 0 20px 2px rgba(0, 0, 0, 0.1);
}

.title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
</style>
<template>
  <div class="login-wrap">
    <el-form label-position="left" :model="userInfo" :rules="rules" ref="userInfo" label-width="0px" class="demo-ruleForm login-container">
      <h3 class="title">用户登录</h3>
      <el-form-item prop="username">
        <el-input type="text" v-model="userInfo.userName" auto-complete="off" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password" v-model="userInfo.password" auto-complete="off" placeholder="密码"></el-input>
      </el-form-item>
      <el-checkbox class="remember" v-model="rememberpwd">记住密码</el-checkbox>
      <el-form-item style="width:100%;">
        <el-button type="primary" style="width:100%;" @click="submitForm('userInfo')" :loading="logining">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script type="text/ecmascript-6">
import {getIsAdmin, setIsAdmin, setToken, setUserInfo} from "@/api/auth";
export default {
  name: 'login',
  data() {
    return {
      //定义loading默认为false
      logining: false,
      // 记住密码
      rememberpwd: false,
      userInfo: {
        id:null,
        userName: 'zm',
        nickName: 'zhMen',
        password:'123456',
        status:null,
        email:'',
        phonenumber:null,
      },
      //rules前端验证
      rules: {
        username: [{ required: true, message: '请输入账号', trigger: 'blur' }],
        password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
        code: [{ required: true, message: '请输入验证码', trigger: 'blur' }]
      }
    }
  },
  methods: {
    submitForm: function (param){
      this.$http.post("/login",this.userInfo,{headers: {isToken: false}}).then(res =>{
        console.log(res.data)
        setToken(res.data.data.token)
        console.log(res.data.data.token)
        setUserInfo(res.data.data.username);
        console.log("是否是管理员"+res.data.data.isAdmin)
        setIsAdmin(res.data.data.isAdmin);
        console.log(getIsAdmin())
        this.$router.push("/Article/Blogs")
        if (res.data.code === 200){
          this.$message({
            message: '恭喜你，登录成功',
            type: 'success'
          });
        }
        else {
          this.$message.error(res.data.data+"登录失败！");
        }
      }).catch(err =>{
        console.log(err)
      })

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
  background-image: image("../assets/background.jpg");
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
.remember {
  margin: 0px 0px 35px 0px;
}
</style>

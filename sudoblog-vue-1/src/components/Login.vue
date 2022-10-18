<template>
  <div class="login-wrap">
    <el-form  class="login-container">
      <h1 class="title">用户登录</h1>
      <el-form-item >
        <el-input type="text" placeholder="用户账号" v-model="username2" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item >
        <el-input type="password" placeholder="密码" v-model="password2" auto-complete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="doLogin" style="width: 100%; margin-right: 10px">登录</el-button>
        <el-row style="text-align: center; margin-top: 10px;">
          <el-link type="primary" @click="toRegister" style="margin-right: 40px">用户注册</el-link>
          <el-link type="primary" @click="toIndex">返回首页</el-link>
        </el-row>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import la from "../components/Leader"
import qs from "qs"
import {
  getFromPath,
  getIsAdmin,
  getToken,
  removeToken,
  removeUserIfo,
  removeUserInfo,
  setIsAdmin,
  setToken,
  setUserInfo
} from "@/api/auth";
import { mapState , mapMutations , mapActions , mapGetters  } from 'vuex';
export default {
  name: "Login",
  components : {
    la,
    qs,
  },
  created() {
    if (getFromPath() === ''){
      alert("该板块需要登录，请登录")
    }
  },
  data() {
    return {
      user:{
        id:null,
        userName: 'zm',
        nickName: 'zhMen',
        password:'123456',
        status:null,
        email:'',
        phonenumber:null,
        sex:null,
        avatar:'',
        userType:'',
        createBy:'',
        createTime:'',
        updateBy:'',
        updateTime:'',
        delFlag:null
      },
      username2: 'zm',
      password2: '123456',
      nickname: 'zhMen',
      created: null,
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请选择密码', trigger: 'change' }
        ],
        nickname: [
          { required: true, message: '请输入昵称', trigger: 'blur' },
          { min: 3, max: 15, message: '长度在 3 到 15 个字符',trigger: 'blur'}
        ],
      },
    }
  },
  methods: {
    doLogin:function(){
      const _this =this
      _this.user.userName = _this.username2;
      _this.user.password = _this.password2;
      //清空user信息
      removeUserInfo()
      removeToken()
      this.$http.post("/user/login", _this.user,{headers: {isToken: false}}).then(res => {
          console.log(res.data)
          setToken(res.data.data.token)
          console.log(res.data.data.token)
          setUserInfo(res.data.data.username);
          console.log("是否是管理员"+res.data.data.isAdmin)
          setIsAdmin(res.data.data.isAdmin);
          console.log(getIsAdmin())
          _this.$router.push("/learn")
          if (res.data.code === 200){
            this.$message({
              message: '恭喜你，登录成功',
              type: 'success'
            });
          }
          else {
            this.$message.error(res.data.data+"登录失败！");
          }
        })
        .catch(err =>{
          console.log(err);
        })
    },
    toRegister:function(){
      this.$router.push('/Register')
    },
    toIndex:function(){
      this.$router.push("/")
    }
  },

};
</script>

<style scoped>
.login-wrap {
  box-sizing: border-box;
  width: 100%;
  height: 100%;
  padding-top: 10%;
  padding-bottom: 10%;
  background-image: url("../assets/image/background.jpg");
  /* background-color: #112346; */
  background-repeat: no-repeat;
  background-position: center right;
  background-size: cover;
}
.login-container {
  border-radius: 20px;
  margin: 0 auto;
  width: 350px;
  padding: 30px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  text-align: center;
  box-shadow: 0 0 20px 2px rgba(0, 0, 0, 0.1);
}

.title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
</style>

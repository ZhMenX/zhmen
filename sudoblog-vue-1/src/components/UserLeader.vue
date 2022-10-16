<template>
  <div style="height: 62px;width: 189px;">
    <h4>欢迎来到树洞！{{userInfo}}</h4>
<!--    <el-button round @click="logout">{{userInfo}}退出登录</el-button>-->
  </div>
</template>

<script>
import { getUserInfo, removeToken, removeUserInfo } from "@/api/auth";

export default {
  name: "UserLeader",
  data(){
    return {
      userInfo: getUserInfo(),
    }
  },
  methods: {
    logout: function () {
      //清空user信息
      removeUserInfo()
      removeToken()
      this.$http.get("user/logout").then(res => {
        this.$router.push("/")
        if (res.data.code === 200){
          this.$message({
            message: '退出成功，回到首页，您现在只能浏览课程页面',
            type: 'success'
          });
        }
      })
    },
  }

};
</script>

<style scoped>

</style>
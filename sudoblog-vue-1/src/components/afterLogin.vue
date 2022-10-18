<template>

  <el-row style="font-size: 15px">
    {{userInfo}}
    <el-button round @click="logout">
      退出登录
    </el-button>
  </el-row>
</template>

<script>
import userLeader from "@/components/UserLeader";
import { getUserInfo, removeIsAdmin, removeToken, removeUserInfo } from "@/api/auth";
export default {
  name: "afterLogin",
  data(){
    return {
      userInfo: getUserInfo(),
    }
  },
  methods: {
    logout: function () {
      removeToken();
      removeUserInfo();
      removeIsAdmin();
      this.$http.get("/user/logout").then(res =>{
         this.$router.go(0)
      })
    },
  },
  components:{
    userLeader,
  }
};
</script>

<style scoped>

</style>

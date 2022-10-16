<template>
  <el-row>
    <el-button round @click="linkRouter('Login')"> 登录 </el-button>
    <el-button round @click="linkRouter('Register')"> 注册 </el-button>
  </el-row>
</template>

<script>
export default {
  name: "beforeLogin",
  methods: {
    linkRouter: function (viewName) {
      this.$router.push({ name: viewName });
    },
  }
};
</script>

<style scoped>

</style>
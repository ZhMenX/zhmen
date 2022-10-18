<template>
  <el-button type="info" round @click="linkRouter('admin')"
  >进入后台</el-button
  >
</template>

<script>
export default {
  name: "afterAdmin",
  methods: {
    linkRouter: function (viewName) {
      //this.$router.push({ name: viewName });
      window.location.href = "http://localhost:9999/#/goods/Goods"  // 这个地址是你要跳转的项目url。
    },
  }
};
</script>

<style scoped>

</style>

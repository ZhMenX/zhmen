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
      this.$router.push({ name: viewName });
    },
  }
};
</script>

<style scoped>

</style>
<template>
  <el-row :gutter="10">
    <el-col :xs="8" :sm="6" :md="4" :lg="3" :xl="1"
      ><img class="mlogo" src="../../assets/image/background.jpg" alt="LOGO" />
    </el-col>
    <el-col :xs="4" :sm="6" :md="8" :lg="9" :xl="11" :push="11">
      <la></la>
    </el-col>
  </el-row>
</template>

<script>
import la from "@/components/Leader";

export default {
  name: "discuss-mysql",
  components: {
    la,
  },
};
</script>
<style scoped>
.mlogo {
  height: 40px;
  margin-top: 18px;
}
</style>

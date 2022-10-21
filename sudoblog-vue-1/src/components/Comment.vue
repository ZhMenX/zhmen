<template>
  <el-row style="font-size: 15px">
    <el-button round @click="comment">
      发表评论
    </el-button>
  </el-row>
</template>

<script>
import userLeader from "@/components/UserLeader";
import { setDialogVisible } from "@/api/auth";
export default {
  name: "Comment",
  //评论组件
  data(){
    return {
      dialogVisible: false
    }
  },
  methods: {
    comment: function () {
      setDialogVisible(true);
    },
  },
  components:{
    userLeader,
  }
};
</script>

<style scoped>

</style>

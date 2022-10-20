/**
* 左边菜单
*/
<template>
  <el-menu default-active="2" :collapse="collapsed" collapse-transition router :default-active="$route.path" unique-opened class="el-menu-vertical-demo" background-color="#334157" text-color="#fff" active-text-color="#ffd04b">
    <div class="logo_box">
      <img class="logo_img" src="../assets/logo.png" alt="">
    </div>
    <el-submenu v-for="menu in allmenu" :key="menu.menuid" :index="menu.menuname">
      <template slot="title">
        <i class="iconfont" :class="menu.icon" style="margin-right: 10px"></i>
        <span>{{menu.menuname}}</span>
      </template>
      <el-menu-item-group>
        <el-menu-item v-for="chmenu in menu.menus" :index="'/'+chmenu.url" :key="chmenu.menuid">
          <i class="iconfont" :class="chmenu.icon"></i>
          <span>{{chmenu.menuname}}</span>
        </el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>
<script>
export default {
  name: 'leftnav',
  data() {
    return {
      collapsed: false,
      allmenu: []
    }
  },
  // 创建完毕状态(里面是操作)
  created() {
    // 获取图形验证码
    let res = {
      success: true,
      data: [
        {
          menuid: 1,
          icon: 'el-icon-chat-line-square',
          menuname: '文章管理',
          hasThird: null,
          url: null,
          menus: [
            {
              menuid: 2,
              icon: 'el-icon-reading',
              menuname: '博客管理',
              hasThird: 'N',
              url: 'Article/Blogs',
              menus: null
            }
          ]
        },
        {
          menuid: 33,
          icon: 'el-icon-goods',
          menuname: '订单管理',
          hasThird: null,
          url: null,
          menus: [
            {
              menuid: 34,
              icon: 'el-icon-shopping-cart-full',
              menuname: '交易订单',
              hasThird: 'N',
              url: 'pay/Order',
              menus: null
            }
          ]
        },
        {
          menuid: 71,
          icon: 'el-icon-s-tools',
          menuname: '系统管理',
          hasThird: null,
          url: null,
          menus: [
            {
              menuid: 72,
              icon: 'el-icon-s-custom',
              menuname: '用户管理',
              hasThird: 'N',
              url: 'system/user',
              menus: null
            },
            {
              menuid: 174,
              icon: 'el-icon-notebook-2',
              menuname: '菜单管理',
              hasThird: 'N',
              url: 'system/Module',
              menus: null
            },
            {
              menuid: 73,
              icon: 'el-icon-user\n',
              menuname: '角色管理',
              hasThird: 'N',
              url: 'system/Role',
              menus: null
            },
            {
              menuid: 74,
              icon: 'icon-cs-manage',
              menuname: '公司管理',
              hasThird: 'N',
              url: 'system/Dept',
              menus: null
            },
            {
              menuid: 75,
              icon: 'el-icon-s-tools',
              menuname: '系统环境变量',
              hasThird: 'N',
              url: 'system/Variable',
              menus: null
            },
            {
              menuid: 76,
              icon: 'el-icon-s-check',
              menuname: '权限管理',
              hasThird: 'N',
              url: 'system/Permission',
              menus: null
            }
          ]
        },
        {
          menuid: 128,
          icon: 'el-icon-s-claim',
          menuname: '支付管理',
          hasThird: null,
          url: null,
          menus: [
            {
              menuid: 129,
              icon: 'el-icon-picture-outline-round',
              menuname: '支付配置信息',
              hasThird: 'N',
              url: 'machine/MachineConfig',
              menus: null
            },
            {
              menuid: 175,
              icon: 'el-icon-s-home',
              menuname: '支付配置',
              hasThird: 'N',
              url: 'pay/Config',
              menus: null
            }
          ]
        },
        {
          menuid: 150,
          icon: 'el-icon-eleme',
          menuname: '图表',
          hasThird: null,
          url: null,
          menus: [
            {
              menuid: 159,
              icon: 'el-icon-s-goods',
              menuname: '数据可视化',
              hasThird: 'N',
              url: 'charts/statistics',
              menus: null
            }
          ]
        }
      ],
      msg: 'success'
    }
          this.allmenu = res.data

    // menu(localStorage.getItem('logintoken'))
    //   .then(res => {
    //     console.log(JSON.stringify(res))
    //     if (res.success) {
    //       this.allmenu = res.data
    //     } else {
    //       this.$message.error(res.msg)
    //       return false
    //     }
    //   })
    //   .catch(err => {
    //     this.$message.error('菜单加载失败，请稍后再试！')
    //   })
    // // 监听
    this.$root.$bus.on('toggle', value => {
      this.collapsed = !value
    })
  }
}
</script>
<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 240px;
  min-height: 400px;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  border: none;
  text-align: left;
}
.el-menu-item-group__title {
  padding: 0px;
}
.el-menu-bg {
  background-color: #1f2d3d !important;
}
.el-menu {
  border: none;
}
.logo_box {
  height: 40px;
  line-height: 40px;
  color: #9d9d9d;
  font-size: 20px;
  text-align: center;
  padding: 20px 0px;
}
.logo_img {
  height: 40px;
}
</style>

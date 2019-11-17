<template>
  <div>
    <el-row style="z-index: 1;float: top">
      <Header style="position: absolute;width: 100%"></Header>
    </el-row>
    <el-row style="z-index: 0">
      <el-col style="width: 250px;" >
        <admin-menu></admin-menu>
      </el-col>
      <user-manage></user-manage>
    </el-row>
  </div>
</template>

<script>
  import AdminMenu from './AdminMenu'
  import Header from './Header'
  import UserManage from './UserManage'
  export default {
    name: 'AdminIndex',
    components: {AdminMenu, Header, UserManage}
  }
</script>

<style scoped>

</style>

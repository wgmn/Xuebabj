<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span style="font-weight: bold;font-size: 20px">最近更新</span>
      <!--<el-button style="float: right; padding: 3px 0" type="text">修改</el-button>-->
    </div>
    <div class="block">
      <el-timeline>
        <el-timeline-item timestamp="2019/10/8" placement="top">
          <el-card>
            <h4>实现上传至服务器和输入 URL 两种方式添加封面</h4>
            <p> 提交于 2019/10/8 21:32</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2019/10/5" placement="top">
          <el-card>
            <h4>实现笔记分类功能</h4>
            <p> 提交于 2019/10/5 09:02</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2019/10/2" placement="top">
          <el-card>
            <h4>实现笔记分页，修复笔记添加的 BUG</h4>
            <p> 提交于 2019/10/2 22:10</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2019/9/29" placement="top">
          <el-card>
            <h4>实现搜索框模糊查询</h4>
            <p> 提交于 2019/9/29 19:51</p>
          </el-card>
        </el-timeline-item>
        <el-timeline-item timestamp="2019/9/27" placement="top">
          <el-card>
            <h4>实现笔记修改功能</h4>
            <p> 提交于 2019/9/27 22:52</p>
          </el-card>
        </el-timeline-item>
      </el-timeline>
    </div>
  </el-card>
</template>

<script>
  export default {
    name: 'UpdateCard'
  }
</script>

<style scoped>
  .box-card {
    margin-top: 5px;
    width: 988px;
    height: 1050px;
    text-align: left;
  }
</style>

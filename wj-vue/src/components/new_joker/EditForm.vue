<template>
  <div>
    <i class="el-icon-circle-plus-outline"  @click="dialogFormVisible = true"></i>
    <el-dialog
      title="添加/修改笔记"
      :visible.sync="dialogFormVisible"
      @close="clear">
      <el-form v-model="form" style="text-align: left" ref="dataForm">
        <el-form-item label="笔记名" :label-width="formLabelWidth" prop="title">
          <el-input v-model="form.title" autocomplete="off" placeholder="不加《》"></el-input>
        </el-form-item>
        <el-form-item label="作者" :label-width="formLabelWidth" prop="author">
          <el-input v-model="form.author" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="上传时间" :label-width="formLabelWidth" prop="date">
          <el-input v-model="form.date" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="对应书名" :label-width="formLabelWidth" prop="press">
          <el-input v-model="form.press" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="封面" :label-width="formLabelWidth" prop="cover">
          <el-input v-model="form.cover" autocomplete="off" placeholder="图片 URL"></el-input>
          <img-upload @onUpload="uploadImg" ref="imgUpload"></img-upload>
        </el-form-item>
        <el-form-item label="简介" :label-width="formLabelWidth" prop="abs">
          <el-input type="textarea" v-model="form.abs" autocomplete="off" ></el-input>
        </el-form-item>
        <el-form-item label="分类" :label-width="formLabelWidth" prop="cid">
        <el-select v-model="form.category.id" placeholder="请选择分类">
          <el-option label="语文" value="1"></el-option>
          <el-option label="数学" value="2"></el-option>
          <el-option label="英语" value="3"></el-option>
          <el-option label="物理" value="4"></el-option>
          <el-option label="化学" value="5"></el-option>
          <el-option label="生物" value="6"></el-option>
          <el-option label="地理" value="7"></el-option>
          <el-option label="历史" value="8"></el-option>
          <el-option label="政治" value="9"></el-option>
        </el-select>
        </el-form-item>
        <el-form-item prop="id" style="height: 0">
          <el-input type="hidden" v-model="form.id" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button @click="dialogFormVisible1=true">内容</el-button>
      </div>
    </el-dialog>
    <el-dialog
      title="笔记内容" :visible.sync="dialogFormVisible1" append-to-body>
      <el-form>
      <el-form-item  prop="content">
        <el-input type="textarea" v-model="form.content" autocomplete="off" rows="30"></el-input>
      </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="onSubmit,dialogFormVisible1=false,dialogFormVisible=false">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import ImgUpload from './ImgUpload'
  export default {
    name: 'EditForm',
    components: {ImgUpload},
    data () {
      return {
        dialogFormVisible: false,
        dialogFormVisible1: false,
        form: {
          content: '',
          id: '',
          title: '',
          author: '',
          date: '',
          press: '',
          cover: '',
          abs: '',
          cid: '',
          category: {
            id: '',
            name: ''
          }
    },
        formLabelWidth: '120px'
      }
    },
    methods: {
      clear () {
        this.$refs.imgUpload.clear()
        this.form = {
          id: '',
          title: '',
          author: '',
          date: '',
          press: '',
          cover: '',
          abs: '',
          category: '',
          content: ''
        }
      },
      onSubmit () {
        this.$axios
          .post('/books', {
            id: this.form.id,
            cover: this.form.cover,
            title: this.form.title,
            author: this.form.author,
            date: this.form.date,
            press: this.form.press,
            abs: this.form.abs,
            category: this.form.category,
            content: this.form.content
          }).then(resp => {
            if (resp && resp.status === 200) {
              this.dialogFormVisible = false
              this.$emit('onSubmit')
            }
        })
      },
      uploadImg () {
        this.form.cover = this.$refs.imgUpload.url
      }
    }
  }
</script>

<style scoped>
  .el-icon-circle-plus-outline {
    margin: 50px 0 0 20px;
    font-size: 100px;
    float: left;
    cursor: pointer;
  }
</style>

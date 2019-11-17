<template>
  <el-dialog
    itle="编辑用户信息"
    :visible.sync="dialogFormVisible">
<el-form :model="form" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
  <el-form-item label="id" prop="id">
  </el-form-item>
  <el-form-item label="原名称修改为">
    <el-input v-model="ruleForm.name"></el-input>
  </el-form-item>
  <el-form-item label="密码" prop="pass">
    <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
  </el-form-item>
  <el-form-item label="确认密码" prop="checkPass">
    <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="submitForm(form)">提交</el-button>
    <el-button @click="resetForm('ruleForm')">重置</el-button>
  </el-form-item>
</el-form>
  </el-dialog>
</template>
<script>
    export default {
        name: 'EditUsers',
        data () {
            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'))
                } else {
                    if (this.ruleForm.checkPass !== '') {
                        this.$refs.ruleForm.validateField('checkPass')
                    }
                    callback()
                }
            }
            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'))
                } else if (value !== this.ruleForm.pass) {
                    callback(new Error('两次输入密码不一致!'))
                } else {
                    callback()
                }
            }
            return {
                dialogFormVisible: false,
                ruleForm: {
                    name: '',
                    pass: '',
                    checkPass: ''
                },
                rules: {
                    pass: [
                        { validator: validatePass, trigger: 'blur' }
                    ],
                    checkPass: [
                        { validator: validatePass2, trigger: 'blur' }
                    ]
                }
            }
        },
        methods: {
            submitForm (formName) {
              this.$axios
                .post('/users/change', {
                  id: this.form.id,
                  username: this.ruleForm.username,
                  password: this.ruleForm.password
                }).then(resp => {
                if (resp && resp.status === 200) {
                  this.dialogFormVisible = false
                  this.$emit('onSubmit')
                }
              })
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        alert('submit!')
                    } else {
                        console.log('error submit!!')
                        return false
                    }
                })
                  this.$axios
                    .post('/users', {
                      id: 13,
                      username: this.ruleForm.name,
                      password: this.ruleForm.pass
                    }).then(resp => {
                    if (resp && resp.status === 200) {
                      this.dialogFormVisible = false
                      this.$emit('onSubmit')
                    }
                  })
            },
          onSubmit () {
            this.$axios
              .post('/books', {
                id: this.form.id,
                username: this.form.username,
                password: this.form.password
              }).then(resp => {
              if (resp && resp.status === 200) {
                this.dialogFormVisible = false
                this.$emit('onSubmit')
              }
            })
          },
            resetForm (formName) {
                this.$refs[formName].resetFields()
            }
        }
    }
</script>

<style scoped>

</style>

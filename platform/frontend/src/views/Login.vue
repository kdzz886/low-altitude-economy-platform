<template>
  <div class="login-container">
    <el-card class="card">
      <h2>用户登录</h2>
      <el-form :model="form" :rules="rules" ref="formRef" label-width="80px">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" />
        </el-form-item>

        <el-form-item label="密码" prop="password">
          <el-input v-model="form.password" type="password" />
        </el-form-item>

        <el-button type="primary" @click="login">登录</el-button>
        <el-button link @click="$router.push('/register')">没有账号？去注册</el-button>
      </el-form>
    </el-card>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from '../api/axios'
import { useUserStore } from '../store/user'


const form = ref({ username: '', password: '' })
const formRef = ref()
const store = useUserStore()

const rules = {
  username: [{ required: true, message: '请输入用户名' }],
  password: [{ required: true, message: '请输入密码' }]
}

const login = () => {
  formRef.value.validate(async valid => {
    if (!valid) return
    const res = await axios.post('/user/login', form.value)
    store.setUser(res.token, form.value.username)
    window.location.href = '/'
  })
}
</script>

<style>
.login-container {
  width: 400px;
  margin: 100px auto;
}
.card { padding: 20px; }
</style>

<template>
  <div class="page">
    <h2>发布需求</h2>

    <el-form :model="form" label-width="100px">
      <el-form-item label="标题">
        <el-input v-model="form.title" />
      </el-form-item>

      <el-form-item label="详细描述">
        <el-input v-model="form.description" type="textarea" rows="5" />
      </el-form-item>

      <el-form-item label="合作方式">
        <el-input v-model="form.method" />
      </el-form-item>

      <el-button type="primary" @click="submit">提交</el-button>
    </el-form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from '../api/axios'

const form = ref({ title: '', description: '', method: '' })

const submit = async () => {
  await axios.post('/demand', form.value)
  alert('发布成功')
  window.location.href = '/demands'
}
</script>

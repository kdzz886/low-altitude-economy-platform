<template>
  <div class="page">
    <h2>需求大厅</h2>

    <el-button type="primary" @click="$router.push('/demands/publish')">
      发布需求
    </el-button>

    <el-table :data="tableData" style="margin-top:20px;">
      <el-table-column prop="title" label="需求标题" />
      <el-table-column prop="company" label="发布企业" />
      <el-table-column prop="time" label="发布时间" />
      <el-table-column prop="status" label="状态" />
    </el-table>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from '../api/axios'

const tableData = ref([])

onMounted(async () => {
  tableData.value = await axios.get('/demand/list')
})
</script>

<template>
  <div class="home">
    <h1>企业需求协同平台</h1>

    <el-input
      v-model="keyword"
      placeholder="搜索需求 / 企业"
      clearable
      style="width: 400px"
    />

    <h2 style="margin-top:40px;">最新需求</h2>
    <el-row :gutter="20">
      <el-col :span="8" v-for="i in 3" :key="i">
        <DemandCard />
      </el-col>
    </el-row>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import DemandCard from '../components/DemandCard.vue'

const keyword = ref('')
</script>

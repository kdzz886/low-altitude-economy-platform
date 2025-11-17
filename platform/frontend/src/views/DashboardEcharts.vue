<template>
  <div>
    <h2>企业数据可视化大屏</h2>

    <div id="map" style="height:400px;"></div>
    <div id="pie" style="height:400px;margin-top:40px;"></div>
  </div>
</template>

<script setup>
import * as echarts from 'echarts'
import { onMounted } from 'vue'

onMounted(() => {
  // 地图
  const map = echarts.init(document.getElementById('map'))
  map.setOption({
    title: { text: '企业分布' },
    xAxis: { type: 'category', data: ['上海','北京','广州'] },
    yAxis: { type: 'value' },
    series: [{ type: 'bar', data: [120, 80, 60] }]
  })

  // 饼图
  const pie = echarts.init(document.getElementById('pie'))
  pie.setOption({
    title: { text: '产业链企业占比' },
    series: [
      {
        type: 'pie',
        data: [
          { value: 40, name: '原材料' },
          { value: 30, name: '制造' },
          { value: 20, name: '服务' }
        ]
      }
    ]
  })
})
</script>

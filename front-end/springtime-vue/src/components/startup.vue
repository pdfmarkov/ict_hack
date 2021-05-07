<template>
  <div id="startup">
    <logo/>
    <loging :access="access" :refresh="refresh" :typeOfPage="type"/>
  </div>
</template>

<script>
  import loging from '@/components/temp_startup/loging'
  import logo from '@/components/temp_startup/logo'

  export default {
    name: 'startup',
    props: ['access', 'refresh', 'type'],
  	components: {
      logo,
      loging,
  	},
  }
</script>

<style>
  #startup {
    min-height: 70vh;
  }
</style>

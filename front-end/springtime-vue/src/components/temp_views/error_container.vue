<template>
  <div id='content'>
    <logo id="logo"/>
    <h1 style="font-size: 600%">{{ errorCode }}</h1>
    <h2>{{ errorMessage }}</h2>
    <br/>
    <hr/>
    <router-link to='/auth' id='backHome'>Вернуться на главную страницу</router-link>
  </div>
</template>

<script>
import logo from "@/components/temp_startup/logo";

export default {
  name: "error_container",
  components: {
    logo,
  },
  props: {
    errorCode: String,
    errorMessage: String
  }
}
</script>

<style scoped>
  h1,h2{
    text-align: center
  }
  #backHome{
    color: white;
    margin-right: auto;
    margin-left: auto;
    max-width: 17em;
    text-align: center;
    padding: 2px;
    letter-spacing: 1px;
    display: block;
    text-decoration: none;
    background-color: #000000;
    border: 2px solid black;
    border-radius: 6px;
  }
  #backHome:hover{
    color: black;
    transition: 0.5s;
    border: 2px solid #000000;
    background-color: #f8f8ff;
  }
</style>
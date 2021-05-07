<template>
<div class="phrase">
  <br>
  <br>
  <h3 class="phrase__text">
    Задача, с которой мы обратились к вашей компании состояла в том, чтобы автоматизировать огромные складские помещения известного всем россиянам магазина одежды. Полученные результаты удивили нас всех, так как компания уменьшила затраты на логистику на 30%, а время доставки грузов на 35%
  </h3>
  <br>
 <div class="phrase__person">
   <div class="phrase__photo">
     <img src="@/assets/man.png" alt="мужик" class="phrase__img" width="90%" height="90%">
   </div>
   <div class="phrase__prof">
     <h2>
       Александр Хауфман
     </h2>
     <h4>
       CEO
     </h4>
   </div>
 </div>
  <br>
  <br>
</div>
</template>

<script>
export default {
  name: "phrase"
}
</script>

<style scoped>

* {
  background: dodgerblue;
  color: white;
}

h1,h2,h3 {
  margin: 0;
}
h4 {
  float: left;
}

.phrase {
  text-align: center;
}

.phrase__text {
  margin: auto;
  width: 50%;
}

.phrase__person{
  font-size: 100%;
  display: inline-flex
}

.phrase__photo{

}

.phrase__img{

}
</style>
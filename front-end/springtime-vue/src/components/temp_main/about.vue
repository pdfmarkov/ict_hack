<template>
<div class="about">
  <div class="about__left">
    <h1 class="about__us">О нас</h1>
    <br>
    <h3>Наша компания работает на рынке автоматизации с <b>2006 года.</b>  Мы автоматизировали больше <b>150</b>  производственных предприятий.</h3>
    <br>
    <h3>Более <b>60%</b> клиентов к нам обращаются повторно с другими задачами автоматизации. Главным нашим подразделением является автоматизация складских помещений по типу компании Amazon</h3>
    <br>
    <button title="Узнать больше" class="btn__more">Узнать больше</button>
  </div>
  <div class="about__right">
   <div style="z-index: 0">
     <img src="@/assets/shelves.png" alt="полки" class="img__shelves" width="90%" height="90%"  >
   </div>
    <div class="about__block">
      <h1 style="color: #0000f3; padding: 0px; font-family: 'Arial Black'; margin-left: 63px"> 150+</h1>
      <br>
      <h1 style="font-size: 19px; font-family: 'Arial Black'; padding: 0px; position: absolute; text-align: center; margin-left: -10px; margin-top: -3px">Законченных проектов</h1>

    </div>



  </div>
</div>

</template>

<script>
export default {
  name: "about",
  methods: {

  },
}
</script>

<style scoped>

* {
  background: white;
}
.about__block{
  width: 250px;
  height: 150px;
  margin-left: -100px;
  padding-right: 25px;
  padding-left: 25px;
  position: absolute;
  margin-top:-80px;
  z-index: 1;
  background-color: white;
  border-radius: 30px;
  box-shadow: -5px 5px 5px rgba(5, 95, 240,0.4);
}

.btn__more {
  font-size: 22px;
  text-align: center;
  margin: 0  0 10px 50px;
  background: dodgerblue;
  border: 2px solid dodgerblue;
  box-sizing: border-box;
  border-radius: 30px;
  color: white;
  transition: all 500ms ease;
}

.btn__more:hover {
  background: white;
  color: dodgerblue;
  box-shadow: inset 0 0 0 3px dodgerblue;
  cursor: pointer;
}

.about {

  height: 100%;
  display: flex;
  align-items: stretch;
}

.about__left {
  margin-right: 20px;
  margin-top: 100px;
  margin-bottom: 100px;
  vertical-align: center;
  float: left;
  width: 50%;
  height: 100%;
  min-height: 100%;
}

.about__right {
  margin-top: 100px;
  margin-bottom: 100px;
  vertical-align: center;
  float: right;
  width: 50%;
  height: 100%;
  min-height: 100%;
}

.about__us {

  color: dodgerblue;
  font-weight: bold;
}

b{
  font-weight: bold;
}
h3 {
  font-size: 140%;
}

.img__shelves {
  filter: drop-shadow( 2px 3px 2px rgba(0, 0, 0, .7));
  box-shadow: inset 0 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 30px;
}

</style>
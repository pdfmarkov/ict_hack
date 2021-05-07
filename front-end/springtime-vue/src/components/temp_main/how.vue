<template>
<div class="how">
  <div class="how__top">
    <h1>
      Как это <b style="color:orange">работает?</b>
    </h1>
    <br>
    <h2>
      Ниже представлена модель работы наших складов и основные элементы разработки
    </h2>
    <br>
  <div class="how__left">
    <img src="@/assets/comp.png" alt="комп" class="img__comp" width="100%" height="100%">

    <h3>
      <br>
      1. Стандартная модель склада включает в себя 4 складских ряда <br>
      2. В каждом ряду находится двя ряда стеллажей работа с которыми ведется через манипулятор с лифтом <br>
      3. Груз к ячейке доставляется по конвейеру <br>
      4. У системы под автоматическим управлением есть два направления: на доставку до ячейки и доставку на отгрузку. По решению администратора возможно перемещение из ячейки в ячейку <br>
      5. Наши программисты разработали систему с помощью следующего программного обеспечения: Visual Studio, Factory I/O и Factory I/O SDK, так же мы имеем возможность работы в данных проектах через TIAportal <br>
      6.  Данные по загруженности склада отоборажаются онлайн на платформе <br>
      7. У вас есть возможность при непредвиденной ситуации быстро получить в месте отгрузки необходимый груз
    </h3>

  </div>
  <div class="how__right">
    <h3>
      1. Платформа доступна на любой вашей технике: от компьютера до планшета
    </h3>
    <br>
    <h3>
      2. У вас под рукой ключевые элементы взаимодействия: <br>
      + Расписание отгрузки <br>
      + Расписание поступления товара <br>
      + Карта склада с обновлением онлайн <br>
      + Личный кабинет для контролирующих сотрудников <br>
      + Возможность срочной отгрузки по вашему запросу
    </h3>
    <br>
    <h3>
      3. Ваш склад изначально оптимизирован на минимальное время для загрузки и отгрузки товара
    </h3>
    <br>
    <img src="@/assets/prog.png" alt="комп" class="img__comp" width="100%" height="100%">
  </div>
  </div>

</div>
</template>

<script>
export default {
  name: "how"
}
</script>

<style scoped>

* {
  background: white;
}

.how {
  display: flex;
}

.how__top {
  margin-top: 60px;
  margin-bottom: 60px;
  width: 100%;
  height: 4%;
}

.how__left {
  margin-top: 60px;
  margin-bottom: 60px;
  margin-left: 50px;
  vertical-align: center;
  float: left;
  width: 45%;
  height: 48%;
}

.how__right {
  margin-top: 60px;
  margin-right: 50px;
  margin-bottom: 60px;
  vertical-align: center;
  float: right;
  width: 45%;
  height: 48%;
}


h3 {
  font-size: 140%;
}

.img__comp {
  filter: drop-shadow( 3px 3px 2px rgba(0, 0, 0, .7));
  box-shadow: inset 0 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 30px;
}

</style>
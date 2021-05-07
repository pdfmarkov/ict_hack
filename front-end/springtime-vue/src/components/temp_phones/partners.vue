<template>
  <div class="how">

    <div class="how__top">
      <img src="@/assets/partners/contact.jpg" alt="Наши контакты" class="img__comp" width="33%" height="8%">
    </div>

    <div id="top_text">
      СТАТЬ ПАРТНЕРОМ
      <br/>
    </div>

    <div style="margin-left:4%;margin-top:2%">
      <div class="how__left">
        <label class="text_1">
          Как вас зовут
        </label>
        <br/>
        <input id="input_1" type="text" placeholder="Иванов Иван" title="почта" size="5">
        <br/>
        <label class="text_1">
          Ваша почта
        </label>
        <br/>
        <input id="input_2" type="email" placeholder="ivanov@mail.ru" title="почта">
        <br/>
        <label class="text_1">
          Ваше сообщение
        </label>
        <br/>
        <input id="input_3" type="text" placeholder="Ваш вопрос или предложение" title="почта">
        <br/>
        <button @click="" title="Кнопка для входа в существующий аккаунт" class="button_1">Отправить сообщение
        </button>
      </div>
    </div>

    <div class="how__right">

      <div>
        <img style="float: left" src="@/assets/partners/phone.jpg" alt="Наши контакты" class="img__comp" width="44,84px" height="50px">
        <label class="top_worlds">
          НАШИ ТЕЛЕФОНЫ
        </label>
        <table class="parthners_table">
          <tr>
        <label class="down_worlds">


              <br/>
              Отдел продаж:
              <br/>
              +7(999)999-99-99
              <br/>
              Отдел по работе с подрядчиком:
              <br/>
              +7(999)999-99-99


        </label>
          </tr>
        </table>
      </div>

      <div>
        <img style="float: left" src="@/assets/partners/yes.jpg" alt="Наши контакты" class="img__comp" width="68,12px" height="49,98px">
        <label class="top_worlds">
          НАША ПОЧТА
        </label>
        <table class="parthners_table">
          <tr>
        <label class="down_worlds">
          <br/>
          Отдел работы с клиентами:
          <br/>
          info@mail.ru
          <br/>
          Оптовый отдел:
          <br/>
          info@mail.ru
        </label>
          </tr>
          </table>
      </div>

      <div>
        <img style="float: left" src="@/assets/partners/geo.jpg" alt="Наши контакты" class="img__comp" width="73,54px" height="50px">
        <label class="top_worlds">
          НАШ АДРЕС
        </label>
        <table class="parthners_table">
          <tr>
        <label class="down_worlds">
          <br/>
          Основной офис:
          <br/>
          г.Москва,ул.Иванова Ивана д.15 оф 101
          <br/>
          Склады:
          <br/>
          г.Москва,ул.Иванова Ивана д.15
        </label>
        </tr>
        </table>
      </div>

    </div>
  </div>

</template>

<script>
export default {
  name: "partners"
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Lato&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Pacifico&display=swap%27');

.parthners_table{
  margin-left: 80px;
  margin-top: -20px;
}

#input_1 { /*переделать*/
  outline: none;
  width: 497.08px; /*ширина инпута  497.08px */
  height: 60px; /*высота инпута*/
  background-color: #F6FBFF;
  color: #4F4F4F;
  border: 1px solid #4F4F4F;
  box-sizing: border-box;
  border-radius: 15px;

  background-image: url("../../assets/partners/person.jpg");
  background-size: 25px 25px; /*размер картинки*/
  background-position-x: 26.67px; /*отступ слево для картинки*/
  background-position-y: 18.33px; /*отступ свурху для картинки*/
  background-repeat: no-repeat; /*Убираем повтор изображения*/
  padding: 21px 320px 16px 79px; /*расположение текста внутри инпута*/
  font-size: 15px; /*размер шрифта*/
  font-style: normal;
  font-weight: normal;
}

#input_2 { /*переделать*/
  outline: none;
  width: 497.08px;
  height: 60px;
  background-color: #F6FBFF;
  color: #4F4F4F;
  border: 1px solid #4F4F4F;
  box-sizing: border-box;
  border-radius: 15px;

  background-image: url("../../assets/partners/mail.jpg");
  background-size: 31.67px 25px;
  background-position-x: 23.3px;
  background-position-y: 18.33px;
  background-repeat: no-repeat; /*Убираем повтор изображения*/
  padding: 21px 301px 16px 79px;
  font-size: 15px; /*размер шрифта*/
  font-style: normal;
  font-weight: normal;

}

#input_3 { /*переделать*/
  outline: none;
  width: 433px;
  height: 100px;
  background-color: #F6FBFF;
  color: #4F4F4F;
  border: 1px solid #4F4F4F;
  box-sizing: border-box;
  border-radius: 15px;

  background-image: url("../../assets/partners/mes.jpg");
  background-size: 31.67px 31.67px;
  background-position-x: 23.3px;
  background-position-y: 15px;
  background-repeat: no-repeat; /*Убираем повтор изображения*/
  padding: 19px 129px 58px 79px;
  font-size: 15px; /*размер шрифта*/
  font-style: normal;
  font-weight: normal;

}

.text_1 {
  width: 131px;
  height: 30px;
  left: 0px;
  top: -2px;

  font-style: normal;
  font-weight: normal;
  font-size: 20px;
  line-height: 30px;
  color: #4F4F4F;

}

.button_1 {
  outline: none;
  position: relative;
  width: 300px;
  height: 46px;
  background: #319CFF;
  border: 2px solid #319CFF;
  border-radius: 30px;
  color: white;
  margin-top: 2%; /*отступ сверху*/
  left: 15%; /*отступ слева*/

  /* текст */
  font-size: 18px;
  display: flex;
  align-items: center;
  text-transform: uppercase;
  margin-bottom: 25%;
}

.button_1 {
  font-size: 22px;
  text-align: center;
  margin: 10px;
  background: dodgerblue;
  border: 2px solid dodgerblue;
  box-sizing: border-box;
  border-radius: 30px;
  color: white;
  transition: all 500ms ease;
}

.button_1:hover {
  background: white;
  color: dodgerblue;
  box-shadow: inset 0 0 0 3px dodgerblue;
  cursor: pointer;
}

.how {
  background: #F6FBFF;
  display: block;
  width: 80%;
  margin: 0 auto;
}

.how__top {
  margin-top: 60px;
  margin-bottom: 60px;
  text-align: center;
}

.how__left {
  alignment: left;
  float: left; /* Обтекание по правому краю */
  margin-right: 0; /* Отступ справа */
  width: 50%; /* Ширина блока */
}

.how__right {
  float: left; /* Выравнивание по правому краю */
  width: 30%;
}

.top_worlds {
  margin-left: 10%;
}

.down_worlds {
  color: #828282;
  margin-left:10%;
}

#top_text {
  border-bottom: 2px solid #319CFF;
  width: 170px;
  padding-top: 10px;

  font-style: normal;
  font-weight: 600;
  font-size: 16px;
  line-height: 19px;
  text-align: center;
}
</style>
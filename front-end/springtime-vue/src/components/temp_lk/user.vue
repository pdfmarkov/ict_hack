<template>
  <div class="user" v-if="isAvailable">
    <div class="user__left">
      <img src="@/assets/chel.png" alt="" style="width: 400px; margin-top: -10px" >

    </div>
    <div class="user__right">

      <table>
        <tr>
          <td>
            <img src="@/assets/pen.png" alt="" style="width: 15px; margin-right: 7px;" @click="changable.firstname = !changable.firstname">
            <label @click="" v-if="changable.firstname === false">{{ (user.firstname === '') || (user.firstname === null) || (user.firstname === undefined) ? 'Введите имя' : user.firstname }}</label>
            <input type="text" placeholder="Введите новое имя" title="имя" v-model="user.firstname" required="true" autocomplete="firstname" v-else>
            <button @click="send('updatefirstname', 'firstname')" title="Подтвердить" class="loging__btn pencil" v-if="changable.firstname === true">
              Подтвердить
            </button>
          </td>
        </tr>
        <tr>
          <td>
            <img src="@/assets/pen.png" alt="" style="width: 15px; margin-right: 7px;" @click="changable.thirdname = !changable.thirdname">
            <label @click="" v-if="changable.thirdname === false">{{ (user.thirdname === '') || (user.thirdname === null) || (user.thirdname === undefined) ? 'Введите отчество' : user.thirdname }}</label>
            <input type="text" placeholder="Введите новое отчество" title="отчество" v-model="user.thirdname" required="true" autocomplete="firstname" v-else>
            <button @click="send('updatethirdname', 'thirdname')" title="Подтвердить" class="loging__btn pencil" v-if="changable.thirdname === true">
              Подтвердить
            </button>
          </td>
        </tr>
        <tr>
          <td>
            <img src="@/assets/pen.png" alt="" style="width: 15px; margin-right: 7px;" @click="changable.secondname = !changable.secondname">
            <label @click="" v-if="changable.secondname === false">{{ (user.secondname === '') || (user.secondname === null) || (user.secondname === undefined) ? 'Введите фамилия' : user.secondname }}</label>
            <input type="text" placeholder="Введите новое фамилия" title="фамилия" v-model="user.secondname" required="true" autocomplete="firstname" v-else>
            <button @click="send('updatesecondname', 'secondname')" title="Подтвердить" class="loging__btn pencil" v-if="changable.secondname === true">
              Подтвердить
            </button>
          </td>
        </tr>
        <tr>
          <td>
<!--        <img src="@/assets/pen.png" alt="" style="width: 15px; margin-right: 7px;" @click="changable.email = !changable.email">    -->
            <img src="@/assets/pen.png" alt="" style="width: 15px; margin-right: 7px;" @click="showMessage('*Скоро появится*')">
            <label @click="" v-if="changable.email === false">{{ user.email === '' ? 'Введите email' : user.email }}</label>
            <input type="text" placeholder="Введите новую email" title="email" v-model="user.email" required="true" autocomplete="firstname" v-else>
            <button @click="send('updateemail', 'email')" title="Подтвердить" class="loging__btn pencil" v-if="changable.email === true">
              Подтвердить
            </button>
          </td>
        </tr>
        <tr>
          <td>
            <img src="@/assets/pen.png" alt="" style="width: 15px; margin-right: 7px;" @click="changable.phone = !changable.phone">
            <label @click="" v-if="changable.phone === false">{{ (user.phone === '') || (user.phone === null) || (user.phone === undefined) ? 'Введите телефон' : user.phone }}</label>
            <input type="text" placeholder="Введите новый телефон" title="телефон" v-model="user.phone" required="true" autocomplete="firstname" v-else>
            <button @click="send('updatephone', 'phone')" title="Подтвердить" class="loging__btn pencil" v-if="changable.phone === true">
              Подтвердить
            </button>
          </td>
        </tr>
      </table>
    </div>
  </div>
  <div v-else>
    <br>
    <h1></h1>
    <br>
  </div>
</template>

<script>

const baseURL = 'http://localhost:41143/';

export default {
  name: "user",
  props: ['firstname','secondname','thirdname','email','phone'],
  data: function () {
    return {
      user: {
        login: '',
        firstname: '',
        secondname: '',
        thirdname: '',
        email: '',
        phone: '',
      },
      changable: {
        firstname: false,
        secondname: false,
        thirdname: false,
        email: false,
        phone: false,
      },
      queries: {
        signin: 'api/aunt/sign_in',
        register: 'api/aunt/register',
      },
    }
  },
  computed: {
    isAvailable: function () {
      return (localStorage.getItem('login') !== null) && (localStorage.getItem('login') !== undefined) && (localStorage.getItem('login') !== '');
    },

  },
  mounted() {
    this.user.login = localStorage.getItem('login');
    this.user.email = localStorage.getItem('login');
    this.getInfo();

  },
  methods: {

    showMessage: function (string) {
      alert(string);
    },

    getInfo: async function () {
      let response = await fetch(baseURL + 'api/aunt/getinfoapi/aunt/getinfo', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json;charset=utf-8',
        },
        body: JSON.stringify(this.user)
      }).catch(function () {
        alert("Error while getting token. Check your connection")
      });

      if (response.ok) {
        try {
          let json = await response.json();
          if (json) {
            this.user.firstname=json.firstname;
            this.user.secondname=json.secondname;
            this.user.thirdname=json.thirdname;
            this.user.phone=json.phone;
          } else {
            let err = new Error('bad respond object [provided empty result]');
            err.data = json;
          }
        } catch (e) {
          console.error(e);
          console.error(`bad respond object: ${e.data}`);
          alert(`bad respond object: ${e.data}`);
        }
      } else {
        console.error(`bad response ${response.statusText} : ${response.status}`);
      }

    },

    send: async function (link, param ) {

        let response = await fetch(baseURL + 'api/aunt/' + link, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json;charset=utf-8',
          },
          body: JSON.stringify(this.user)
        }).catch(function () {
          alert("Error while getting token. Check your connection")
        });

        console.log('sent request');
        console.log('check if status 201');

        let json = null;
        try {
          json = await response.json();
        } catch (e) {
          console.error(e);
          return;
        }

        if (response.ok) {
          console.log(`response body: ${JSON.stringify(json)}`);
          if (!json)
            console.log('bad data: expected { email }');
          else {
            if (param === 'firstname') {
              this.user.firstname=json.firstname;
              this.changable.firstname=false;
            } else if (param === 'secondname') {
              this.user.secondname=json.secondname;
              this.changable.secondname=false;
            } else if (param === 'thirdname') {
              this.user.thirdname=json.thirdname;
              this.changable.thirdname=false;
            } else if (param === 'email') {
              this.user.email=json.email;
              this.changable.email=false;
            } else if (param === 'phone') {
              this.user.phone=json.phone;
              this.changable.phone=false;
            }

          }
        } else {
          alert(`*${json.description}`);
        }

    },

  },

}
</script>

<style scoped>

  TABLE {
    margin-top: 50px;
    margin-left: 10px;
    width: 300px; /* Ширина таблицы */
    border-collapse: collapse; /* Убираем двойные линии между ячейками */
    border: 1px solid rgba(0, 0, 0, 0.4);
  }
  TD, TH {
    font-family:Bruno;
    font-weight: bold;
    padding: 5px; /* Поля вокруг содержимого таблицы */
    border: 1px solid rgba(0, 0, 0, 0.4);
    text-align: left; /* Выравнивание по левому краю */
  }

  h{
    margin-left: 30px;
  }

  .pencil {
    height: 50%;
  }

  .user {
    height: 100%;
    display: flex;
    align-items: stretch;
  }

  .user__left {
    margin-left: -460px;
    margin-top: 100px;
    margin-bottom: 100px;
    float: left;
    width: 400px;
  }

  .user__right {
    margin-top: 100px;
    margin-bottom: 100px;
    vertical-align: center;
    float: right;
  }

  .user__us {
    color: dodgerblue;
    font-weight: bold;
  }

  b{
    font-weight: bold;
  }

  svg{
    border-radius: 15px;
    border-color: black;
    margin: 0 0 0 50px;
    filter: drop-shadow( 3px 3px 2px rgba(0, 0, 0, .7));

  }

</style>
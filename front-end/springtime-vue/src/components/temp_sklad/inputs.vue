<template>
    <div>
        <div style="margin-left: 450px; margin-top: 50px; position:center">


            <table>
                <td>
                    <tr>
                        <button class="input_11 b">Рассчитать</button>
                    </tr>
                    <tr>
                        <input class="input_11" type="text" placeholder="Время на операцию" title="почта" size="5">
                    </tr>
                    <tr>
                        <input class="input_11" type="text" placeholder="Оптимальное Расположение" title="почта"
                               size="5">
                    </tr>
                    <tr>
                        <input class="input_11" type="text" placeholder="Сгруппировать товары  на складе по типу"
                               title="почта" size="5">
                    </tr>
                    <tr>
                        <input class="input_11" type="text" placeholder="Сгруппировать товары  на складе по отгрузке"
                               title="почта" size="5">
                    </tr>
                    <tr>
                        <input class="input_11" type="text" placeholder="Занимемое место" title="почта" size="5">
                    </tr>
                    <tr>
                        <input class="input_11" type="text" placeholder="Свободное место" title="почта" size="5">
                    </tr>
                </td>
                <td>
                    <tr>
                        <button class="input_11 b s">Открыть базу данных склада</button>
                    </tr>
                    <tr>
                        <input class="input_11 b s" type="text" placeholder="Сортировка" title="почта" size="5">
                    </tr>
                    <tr>
                        <input class="input_11 s" type="text" placeholder="Количество" title="почта" size="5">
                    </tr>
                    <tr>
                        <input class="input_11 s" type="text" placeholder="Тип" title="почта" size="5">
                    </tr>
                    <tr>
                        <input class="input_11 s" type="text" placeholder="Расположение" title="почта" size="5">
                    </tr>
                </td>

            </table>
            <div>
                <button style="background-color: #0dabf5; width: 250px; height: 55px;margin-bottom:100px; margin-top:30px;border-radius: 7px;outline: 0 none !important;color: white;font-family: 'Arial';font-size: 20px; border-color: white">
                    Выгрузить отчет
                </button>

            </div>
            <div>
              <input type="file" id="file" ref="file" v-on:change="handleFileUpload()" />
              <button v-on:click="submitFile()" style="background-color: #0dabf5; width: 250px; height: 55px;margin-bottom:100px; margin-top:30px;border-radius: 7px;outline: 0 none !important;color: white;font-family: 'Arial';font-size: 20px; border-color: white">
                Загрузить данные
              </button>
              <br>
              <input class="input_11 s" type="text" placeholder="Введите название файла (с расширением)" title="почта" size="5" v-model="name" style="margin-left: 0;margin-right: 10px">
              <button @click="download()" style="background-color: #0dabf5; width: 250px; height: 55px;margin-bottom:100px; margin-top:30px;border-radius: 7px;outline: 0 none !important;color: white;font-family: 'Arial';font-size: 20px; border-color: white">
                Получить данные
              </button>
            </div>
        </div>
    </div>
</template>

<script>

const baseURL = 'http://localhost:41143/';

    export default {
      name: "inputs",
      data(){
        return {
          file: '',
          name: ''
        }
      },
        methods: {
        async download() {
          if ((this.name !== null) && (this.name !== undefined) && (this.name !== ''))
          {

            fetch(baseURL + 'main/file/download/' + this.name)
                .then(res => res.blob())
                .then(blob => {
                  if (blob.size === 0) alert('Такой файл не был найден')
                  else {
                    console.log(blob)
                    let file = window.URL.createObjectURL(blob);
                    const link = document.createElement('a');
                    link.href = file;
                    link.setAttribute('download', 'nti.csv');
                    document.body.appendChild(link);
                    link.click();
                  }
                });
          } else alert('Поле не должно быть пустым!');

        },

          handleFileUpload() {
            this.file = this.$refs.file.files[0];
            console.log(this.file.name)
          },
          async submitFile() {
          if ((this.file !== null) && (this.file !== undefined) && (this.file !== ''))
            {
              let fileType = this.file.name.split('.')[1];
              if (fileType === 'csv') {
                let formData = new FormData();
                formData.append('file', this.file);

                let response = await fetch(baseURL + 'main/file/upload', {
                  method: 'POST',
                  // headers: {
                  //   'Content-Type': 'multipart/form-data',
                  // },
                  body: formData
                }).catch(function () {
                  alert("Error while getting token. Check your connection")
                });
              } else alert('Файл должен быть формата CSV');
            } else alert('Сначала загрузите файл');
          },
      },
    }
</script>

<style scoped>


    .input_11 { /*переделать*/

        outline: none;
        width: 300px; /*ширина инпута  497.08px */
        height: 30px; /*высота инпута*/
        background-color: #F6FBFF;
        color: #4F4F4F;
        border: 1px solid #4F4F4F;
        box-sizing: border-box;
        border-radius: 15px;
        padding-left: 10px;


        font-size: 14px; /*размер шрифта*/
        font-style: normal;
        font-weight: normal;
    }
.input_11.s{

    margin-left: 100px;
}
    .input_11.b { /*переделать*/

        outline: none;
        width: 300px; /*ширина инпута  497.08px */
        height: 70px; /*высота инпута*/
        background-color: #F6FBFF;
        color: #4F4F4F;
        border: 1px solid #4F4F4F;
        box-sizing: border-box;
        border-radius: 20px;
        padding-left: 10px;


        font-size: 20px; /*размер шрифта*/
        font-style: normal;
        font-weight: normal;
    }

    .input_11:hover {
        background-color: rgba(255, 0, 0, 0.2);
    }

    .input_11.b:hover {
        background-color: rgba(0, 255, 0, 0.2);
    }
</style>
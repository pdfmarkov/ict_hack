<template>
    <div style="background-color: white">

        <div style="margin-left: 300px; margin-bottom: 50px; margin-right: 100px; float: left;">
        <table border="1">
            <tr>
                <td class="d"></td>
                <td class="d">1</td>
                <td class="d">2</td>
                <td class="d">3</td>
                <td class="d">4</td>
                <td class="d">5</td>
                <td class="d">6</td>
                <td class="d">7</td>
                <td class="d">8</td>
                <td class="d">9</td>
            </tr>
            <tr>
                <td class="d">1</td>
                <td class="defined" bgcolor="#ffbbbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
            </tr>
            <tr>
                <td class="d">2</td>
                <td class="defined" bgcolor="#ffbbbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
            </tr>
            <tr>
                <td class="d">3</td>
                <td class="defined" bgcolor="#ffbbbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
            </tr>
            <tr>
                <td class="d">4</td>
                <td class="defined" bgcolor="#ffbbbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
            </tr>
            <tr>
                <td class="d">5</td>
                <td class="defined" bgcolor="#ffbbbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
            </tr>
            <tr>
                <td class="d">6</td>
                <td class="defined" bgcolor="#ffbbbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
                <td class="defined" bgcolor="#bbffbb"><a class="fullcell" href="#"></a></td>
            </tr>
        </table>
        </div>
    </div>
</template>

<script>
    export default {
        name: "tables"
    }
</script>

<style scoped>

    TABLE {
        height: 300px;
        width: 300px;
        border-collapse: collapse; /* Убираем двойные линии между ячейками */
    }
    TD, TH {
        padding: 3px; /* Поля вокруг содержимого таблицы */
        border: 1px solid #ffffff; /* Параметры рамки */
    }

    td.defined {
        width: 30px;
        height: 30px;
        text-align: center;
        background-color: #0dabf5;
        border-radius: 5px;
    }
    td.defined:hover {
        background: #7f7979; /* Цвет фона при наведении */
        color: #fff; /* Цвет текста при наведении */
    }
    td.d {


        text-align: center;
        position: center;
        width: 30px;
        height: 30px;
        background-color: #ffffff;
    }

    td a.fullcell {
        width: 100%;
        height: 100%;
        display: block;
    }




</style>
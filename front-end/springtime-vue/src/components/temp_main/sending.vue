<template>
    <div class="sending">
        <div class="sending_table">
            <table>
                <tr>

                    <td>

                        <select>
                            <option label="Расположение" value="1" disabled selected>Господин Электроник</option>
                            <option>Москва</option>
                            <option>Санкт-Петербург</option>
                            <option>Пермь</option>
                        </select>
                    <td>

                        <select>
                            <option label="Название организации" value="1" disabled selected>Господин Электроник
                            </option>
                            <option>ИТМО</option>
                            <option>СПБГУ</option>
                            <option>Политех</option>
                        </select>
                    </td>

                    <td>

                        <select>
                            <option label="Размеры вашего склада" value="1" disabled selected>Господин Электроник
                            </option>
                            <option>Маленький</option>
                            <option>Большой</option>
                            <option>Really big</option>
                        </select>
                    </td>
                    <td>

                        <select>
                            <option label="Как с вами связаться" value="1" disabled selected>Господин Электроник
                            </option>
                            <option>Факс</option>
                            <option>Почта</option>
                            <option>Звонок</option>
                        </select>
                    </td>

                    <td>
                        <button style="width: 155px; height: 42px;border-color: white;
                          border-radius: 8px; background-color: dodgerblue; font-weight: normal;color: white;font-family:  'Arial';outline: 0 none !important;box-shadow: white">
                            Отправить
                        </button>
                    </td>
                </tr>
            </table>
        </div>

    </div>

</template>

<script>
    export default {
        name: "sending"
    }
</script>

<style scoped>
    .sending_table {
        position: absolute;
        margin-left: 100px;

    }

    select {
        border-color: white;
        font-size: 120%;
        width: 100%;
        outline: 0 none !important;
    }

    TD, TR {
        padding-left: 50px;
        outline: 0 none !important;
    }

    .sending {
        background: white;
        outline: 0 none !important;
    }

</style>
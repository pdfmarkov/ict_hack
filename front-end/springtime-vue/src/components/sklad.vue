<template>
    <div>
        <upper/>
      <h1>Автоматизация склада</h1>
        <h2>Карта склада</h2>
        <tables/>
        <tables/>
        <tables/>
        <tables/>
        <inputs/>
        <downer/>
    </div>
</template>

<script>
    import upper from "@/components/temp_main/upper";
    import downer from "@/components/temp_main/downer";
    import tables from "@/components/temp_sklad/tables";
    import inputs from "@/components/temp_sklad/inputs";

    export default {
        name: "sklad",
        components: {
            upper,
            downer,
            tables,
            inputs
        },
    }

</script>

<style scoped>
    h1{
        font-family: Arial, sans-serif;
        font-size: 30px;
        text-align: center;

    }
    h2{
        font-family: Arial, sans-serif;
        font-size: 25px;
        text-align: left;
        margin-left: 300px;
        margin-bottom: 30px;
        margin-top: 30px;

    }

</style>
<template>
    <div>
        <h1 class="alert alert-success">CompositionApi입니다</h1>

        <h3>Counter:{{ counter }}</h3>
        <button v-on:click="NumIncre">증가</button>
        <button @click="NumDecre">감소</button>
    </div>
</template>

<script>
import { onMounted, ref } from 'vue';

export default {
    setup () {
        
        const counter=ref(0);
        const NumIncre=()=>counter.value++;
        const NumDecre=()=>counter.value--;

        onMounted(()=>{
            console.log("컴포넌트가 마운트됨");
        })

        return {
            counter,
            NumIncre,
            NumDecre
        }
    }
}
</script>

<style lang="scss" scoped>

</style>
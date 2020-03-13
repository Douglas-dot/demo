<template>
  <div class="hello">
    <h1>列表</h1>
    <h2>Female</h2>
    <div v-for="item in list" v-bind:key="item.gender">
      <div v-if="item.gender === 'Female'">
        <div v-for="(pet,index) in item.pets" v-bind:key="pet.type">
          <div v-if="pet.type === 'Cat' && index == 0">
            {{ item.name }}
          </div>
        </div>
      </div>
    </div>
    <h2>Male</h2>
    <div v-for="item in list" v-bind:key="item.gender">
      <div v-if="item.gender === 'Male'">
        <div v-for="(pet,index) in item.pets" v-bind:key="pet.type">
          <div v-if="pet.type === 'Cat' && index == 0">
            {{ item.name }}
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      list: [],
      sortType: 'name'
    }
  },
  created () {
    this.getlist()
  },
  methods: {
    getlist () {
      let _this = this
      _this.$http.get('http://5c92dbfae7b1a00014078e61.mockapi.io/owners').then(res => {
        _this.list = _this.sortByKey(res.data, this.sortType)
      })
    },
    sortByKey (array, key) {
      return array.sort(function (a, b) {
        let x = a[key]
        let y = b[key]
        return ((x < y) ? -1 : ((x > y) ? 1 : 0))
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>

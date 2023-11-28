<template>
  <div class="container">
    <div v-for="(task, index) in tasks" :key="index">
      <h3>{{ task.title }}</h3>
      <p>{{ task.description }}</p>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "HelloWorld",
  props: {
    msg: String,
  },
  data() {
    return {
      tasks: [],
    };
  },
  mounted() {
    this.getTasks();
  },
  methods: {
    getTasks() {
      axios
        .get("http://localhost:8080/task/")
        .then((response) => {
          console.log(response);
          this.tasks = response.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
};
</script>

<style scoped>
.container {
  background-color: aliceblue;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-around;
}

.container div {
  margin: 0.5em;
  border: 0.3em solid black;
  padding: 0.5em;
  flex-grow: 1;
}
</style>


mongo "mongodb+srv://joy854:sinha125@buildout-qa.8uhyd.mongodb.net/buildoutDatabase" <<EOF
db.qa.insert([
    {
      "moduleId":"1",
      "questionId": "001",
      "title": "What is the default IP address of localhost?",
      "description": "General question",
      "type": "objective-single",
      "options": {
        "1": "0.0.0.0",
        "2": "192.168.0.12",
        "3": "127.0.0.1",
        "4": "255.255.255.255"
      },
      "correctAnswer": [
        "4"
      ]
    },
    {
      "moduleId":"1",
      "questionId": "002",
      "title": "Which of the following will not result in CompilationError?",
      "description": "Java question",
      "type": "objective-multiple",
      "options": {
        "1": "List a=new ArrayList<>();",
        "2": "List b=new Collection<>();",
        "3": "List c=new ArrayList();",
        "4": "List<? extends Object> d=new ArrayList();"
      },
      "correctAnswer": [
        "1",
        "3",
        "4"
      ]
    },
    {
      "moduleId":"1",
      "questionId": "004",
      "title": "Which of the following will not result in CompilationError?",
      "description": "Java question",
      "type": "objective-multiple",
      "options": {
        "1": "List a=new ArrayList<>();",
        "2": "List b=new Collection<>();",
        "3": "List c=new ArrayList();",
        "4": "List<? extends Object> d=new ArrayList();"
      },
      "correctAnswer": [
        "1",
        "3",
        "4"
      ]
    },
    {
      "moduleId":"1",
      "questionId": "005",
      "title": "Which of the following will not result in CompilationError?",
      "description": "Java question",
      "type": "objective-multiple",
      "options": {
        "1": "List a=new ArrayList<>();",
        "2": "List b=new Collection<>();",
        "3": "List c=new ArrayList();",
        "4": "List<? extends Object> d=new ArrayList();"
      },
      "correctAnswer": [
        "1",
        "3",
        "4"
      ]
    },
    {
      "moduleId":"1",
      "questionId": "006",
      "title": "Which of the following will not result in CompilationError?",
      "description": "Java question",
      "type": "objective-multiple",
      "options": {
        "1": "List a=new ArrayList<>();",
        "2": "List b=new Collection<>();",
        "3": "List c=new ArrayList();",
        "4": "List<? extends Object> d=new ArrayList();"
      },
      "correctAnswer": [
        "1",
        "3",
        "4"
      ]
    },
    {
      "moduleId":"1",
      "questionId": "007",
      "title": "Which of the following will not result in CompilationError?",
      "description": "Java question",
      "type": "objective-multiple",
      "options": {
        "1": "List a=new ArrayList<>();",
        "2": "List b=new Collection<>();",
        "3": "List c=new ArrayList();",
        "4": "List<? extends Object> d=new ArrayList();"
      },
      "correctAnswer": [
        "1",
        "3",
        "4"
      ]
    },
    {
      "moduleId":"1",
      "questionId": "008",
      "title": "Which of the following will not result in CompilationError?",
      "description": "Java question",
      "type": "objective-multiple",
      "options": {
        "1": "List a=new ArrayList<>();",
        "2": "List b=new Collection<>();",
        "3": "List c=new ArrayList();",
        "4": "List<? extends Object> d=new ArrayList();"
      },
      "correctAnswer": [
        "1",
        "3",
        "4"
      ]
    },
    {
      "moduleId":"1",
      "questionId": "009",
      "title": "Which of the following will not result in CompilationError?",
      "description": "Java question",
      "type": "objective-multiple",
      "options": {
        "1": "List a=new ArrayList<>();",
        "2": "List b=new Collection<>();",
        "3": "List c=new ArrayList();",
        "4": "List<? extends Object> d=new ArrayList();"
      },
      "correctAnswer": [
        "1",
        "3",
        "4"
      ]
    },
    {
      "moduleId":"1",
      "questionId": "010",
      "title": "Which of the following will not result in CompilationError?",
      "description": "Java question",
      "type": "objective-multiple",
      "options": {
        "1": "List a=new ArrayList<>();",
        "2": "List b=new Collection<>();",
        "3": "List c=new ArrayList();",
        "4": "List<? extends Object> d=new ArrayList();"
      },
      "correctAnswer": [
        "1",
        "3",
        "4"
      ]
    },
    {
      "moduleId":"1",
      "questionId": "003",
      "title": "What is the parent class/interface of Exception class?",
      "description": "Java question",
      "type": "subjective",
      "correctAnswer": [
        "throwable"
      ]
    },
    {
      "moduleId":"1",
      "questionId": "011",
      "title": "What is the parent class/interface of Exception class?",
      "description": "Java question",
      "type": "subjective",
      "correctAnswer": [
        "throwable1"
      ]
    },
    {
      "moduleId":"1",
      "questionId": "012",
      "title": "What is the parent class/interface of Exception class?",
      "description": "Java question",
      "type": "subjective",
      "correctAnswer": [
        "throwable"
      ]
    }
  ])
EOF
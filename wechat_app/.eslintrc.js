module.exports = {
    "extends": "airbnb-base",
    "env": {
        "es6": true,
        "node": true
      },
      "plugins": [
        "import"
      ],
      "rules": {
        "comma-dangle": [
          "warn",
          "only-multiline"
        ],
        // "indent": [
        //   2,
        //   2,
        //   {
        //     "SwitchCase": 1
        //   }
        // ],
        "no-console": 0,
        // "no-alert": 0,
        // "global-require": 0,
        // "object-shorthand": [
        //   2,
        //   "always",
        //   {
        //     "avoidQuotes": false
        //   }
        // ],
        // "import/no-extraneous-dependencies": 0,
        // "no-plusplus": [
        //   "error",
        //   {
        //     "allowForLoopAfterthoughts": true
        //   }
        // ],
        "import/prefer-default-export": 0,
        "no-unused-vars": [
          "warn"
          // {
          //   "varsIgnorePattern": "regeneratorRuntime"
          // }
        ],
        // support develop in windows
        "linebreak-style": [
          0,
          "error",
          "windows"
        ]
      },
      "globals": {
        "App": true,
        "Page": true,
        "wx": true,
        "getApp": true
      }
};
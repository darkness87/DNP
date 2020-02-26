module.exports = {
  "transpileDependencies": [
    "vuetify"
  ],
  pluginOptions: {
    electronBuilder: {
      builderOptions: {
        appId: 'dnp',
        asar: false,
        productName: 'DNP',
        win: {
          target: [
            {
              target: 'portable',
              arch: [
                'x64',
              ],
            },
          ],
        },
      },
    },
  },
}
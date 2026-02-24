ChestShop-Towny
================================

[ChestShop](https://github.com/ChestShop-authors/ChestShop-3) addon to work with [Towny](https://github.com/TownyAdvanced/Towny)

Requires the use of Towny 0.102.0.0 or newer!

Requires the use of ChestShop Build 433 (Jun 9, 2025) or newer!


Using on a server
--------------------------------

Just throw the .jar into your /plugins folder.


Permissions
--------------------------------

- ChestShop.towny.bypass:
  - default: op

- ChestShop.towny.create.townshop:
  - default: op
  - Give to mayors in the townyperms.yml to allow them to create shops linked to the town's bank account.
  - ChildNodes: 
    - ChestShop.towny.create.townshop.buy
    - ChestShop.towny.create.townshop.sell
- ChestShop.towny.create.townshop.buy
  - default: op
  - Allows players to create buy shops for their town account.
- ChestShop.towny.create.townshop.sell
  - default: op
  - Allows players to create sell shops for their town account.

- ChestShop.towny.create.nationshop:
  - default: op
  - Give to kings in the townyperms.yml to allow them to create shops linked to the nation's bank account.
  - ChildNodes: 
    - ChestShop.towny.create.nationshop.buy
    - ChestShop.towny.create.nationshop.sell
- ChestShop.towny.create.nationshop.buy
  - default: op
  - Allows players to create buy shops for their nation account.
- ChestShop.towny.create.nationshop.sell
  - default: op
  - Allows players to create sell shops for their nation account.

Town & Nation shops
--------------------------------

When given the correct permission nodes, mayors and kings can create town and nation shops.
These shops are prefixed with a configurable prefix on their signs, (defaulting to `t-` and `n-`,) followed by the town or nation name. ie: `t-BestTownEver`.
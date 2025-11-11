ChestShop-Towny
================================

[ChestShop](https://github.com/ChestShop-authors/ChestShop-3) addon to work with [Towny](https://github.com/TownyAdvanced/Towny)

Requires the use of Towny 0.101.1.0 or newer!

Requires the use of ChestShop Build 433 (Jun 9, 2025) or newer!


Using on a server
--------------------------------

Just throw the .jar into your /plugins folder.


Permissions
--------------------------------

- ChestShop.towny.bypass:
  - default: op
- ChestShop.towny.townshop:
  - default: op
  - Give to mayors in the townyperms.yml to allow them to create shops linked to the town's bank account.
- ChestShop.towny.nationshop:
  - default: op
  - Give to kings in the townyperms.yml to allow them to create shops linked to the nation's bank account.


Town & Nation shops
--------------------------------

When given the correct permission nodes, mayors and kings can create town and nation shops.
These shops are prefixed with a configurable prefix on their signs, (defaulting to `t-` and `n-`,) followed by the town or nation name. ie: `t-BestTownEver`.
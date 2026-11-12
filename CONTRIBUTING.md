# Como contribuir

1. Crie uma branch a partir da `main`: `git switch -c <seu-caso-de-uso>/<o-que-faz>`.
2. Rode `mvn verify` antes de abrir o PR.
3. Abra o PR e peça revisão para alguém de **outra dupla**.
4. Depois de aprovado e com o CI verde, faça o merge.

Regra da arquitetura (o CI verifica): uma camada só pode usar as camadas mais internas.
`domain` não usa nada; `application` usa `domain`; `adapters` usa `application`; `infrastructure` usa todas.

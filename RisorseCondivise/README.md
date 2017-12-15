# Ingaliso Carlo

File Task: Task rappresenta il compito (Runnable) di un singolo thread. Tale classe accederà alle risorse.

File Risorsa: realizza mediante un semaforo binario (un solo permits) la risorsa.

File Simul1: In questo primo caso i due thread non possono usare la risorsa non condivisibile in contemporanea (zona V) e quindi non possono entrare in zona vietata.

![Simul1](https://user-images.githubusercontent.com/8972836/31275301-07b37360-aa97-11e7-8b74-88cae8389a5e.png)

File Simul2: In questo secondo caso ogni singolo thread usa due risorse e vie è un momento in cui le usa entrambe, ma i due tread accedono in modo analogo alle risorse (prima la prima risorsa e poi la seconda). 

![Simul2](https://user-images.githubusercontent.com/8972836/31275302-07bad36c-aa97-11e7-8437-96218298b074.png)

File Simul3: In quest'ultimo caso i thread accedono in modo diverso alle risorse (in ordine opposto): non possono accedere ad alcune zone (zona I) e si intrappolano in altre (zona T) dando luogo ad un deadlock.

![Simul3](https://user-images.githubusercontent.com/8972836/31275303-07c86162-aa97-11e7-8040-eeccfa9ab2ef.png)

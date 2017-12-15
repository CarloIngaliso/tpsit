# Ingaliso Carlo

file Task: Task rappresenta il compito (Runnable) di un singolo thread. Tale classe accederà alle risorse.

file Risorsa: realizza mediante un semaforo binario (un solo permits) la risorsa.

file Simul1: In questo primo caso i due thread non possono usare la risorsa non condivisibile in contemporanea (zona V) e quindi non possono entrare in zona vietata.

file Simul2: In questo secondo caso ogni singolo thread usa due risorse e vie è un momento in cui le usa entrambe, ma i due tread accedono in modo analogo alle risorse (prima la prima risorsa e poi la seconda). 

file Simul3: In quest'ultimo caso i thread accedono in modo diverso alle risorse (in ordine opposto): non possono accedere ad alcune zone (zona I) e si intrappolano in altre (zona T) dando luogo ad un deadlock.

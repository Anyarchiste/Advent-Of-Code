<#Creates 25 folders named "dayXX" where XX = 01->25
WARNING it creates the folder in the folder it is in. Make sure you are in
the right one#>

$A = 25

for ($i = 1; $i -lt ($A + 1); $i++) {
    $path = ""
    if ($i -lt 10) {
        <# Action to perform if the condition is true #>
        $path = ("./day0" + $i)
    } elseif ($i -ge 10) {
        <# Action when this condition is true #>
        $path = ("./day" + $i)
    }

    New-Item -ItemType Directory -Path $path
}

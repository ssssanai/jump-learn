function checkSQLInjection(str) {
    if (str.includes('--') || str.includes('$$') || str.includes('#') || str.includes('/*')) return false;
    else return true;
}
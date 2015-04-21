CREATE FUNCTION dbo.gcd (@a bigint, @b int) RETURNS int AS
BEGIN
	IF @b = 0 RETURN @a
	RETURN dbo.gcd(@b, @a % @b)
END
GO
DECLARE @i int = 2
DECLARE @total bigint = 1
WHILE @i <= 20
BEGIN
	SET @total = @total * @i / dbo.gcd(@total, @i)
	SET @i = @i + 1
END
SELECT @total